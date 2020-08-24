package example.kotlin.room.mvvm.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.kotlin.room.mvvm.R
import example.kotlin.room.mvvm.adapter.RecyclerViewAdapter
import example.kotlin.room.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    lateinit var strUsername: String
    lateinit var strPassword: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity
        loginViewModel = ViewModelProvider(context as MainActivity).get(LoginViewModel::class.java)
        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
        recyclerView.layoutManager = linearLayoutManager
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.d("TAG", "$exception handled !")
        }
        val handler1 = CoroutineExceptionHandler { _, exception ->
            Log.d("TAG", "$exception handled !")
        }

        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main + handler+handler1) {

        loginViewModel.getAllUses(context as MainActivity)!!.observe(this@MainActivity, Observer {

            if (it.size==0) {
                lblUsesResponse.text = "Data Not Found"
            } else {
                recyclerView.adapter = RecyclerViewAdapter(it)
                lblUsesResponse.text = "Data found Sucessfully"
            }
        })

        }
        btnAddLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPhone.text.toString().trim()
            if (strUsername.isEmpty()) {
                txtUsername.error = "PLease enter the username"
            } else if (strPassword.isEmpty()) {
                txtPhone.error = "Please enter the password"
            } else {
                // Insert data into table
                doAsync {
                    loginViewModel.insertData(context, strUsername, strPassword)
                }
                lblInsertResponse.text = "Inserted Successfully"
            }

        }





}
}