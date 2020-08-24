package example.kotlin.room.mvvm.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.kotlin.room.mvvm.R
import example.kotlin.room.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    lateinit var strUsername: String
    lateinit var strPassword: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity
        loginViewModel = ViewModelProvider(context as MainActivity).get(LoginViewModel::class.java)
        btnAddLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPassword.text.toString().trim()
            if (strUsername.isEmpty()) {
                txtUsername.error = "PLease enter the username"
            } else if (strPassword.isEmpty()) {
                txtPassword.error = "Please enter the password"
            } else {
                loginViewModel.insertData(context, strUsername, strPassword)
                lblInsertResponse.text = "Inserted Successfully"
            }
        }
        btnReadLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            loginViewModel.getLoginDetails(context as MainActivity, strUsername)!!
                .observe(this, Observer {

                    if (it == null) {
                        lblInsertResponse.text = "Data Not Found"
                        lblUseraname.text = "- - -"
                        lblPassword.text = "- - -"
                    } else {
                        lblUseraname.text = it.Username
                        lblPassword.text = it.Password
                        lblInsertResponse.text = "Data found Sucessfully"
                    }
                })
        }
    }
}