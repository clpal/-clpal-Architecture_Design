package example.kotlin.room.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.kotlin.room.mvvm.model.LoginTableModel
import example.kotlin.room.mvvm.repository.LoginRepository
import example.kotlin.room.mvvm.view.MainActivity

class LoginViewModel : ViewModel() {
    var liveDataLogin: LiveData<LoginTableModel>? = null
    fun insertData(context: Context, username: String, password: String) {
        LoginRepository.insertData(context, username, password)
    }

    fun getLoginDetails(context: MainActivity, strUsername: String): LiveData<LoginTableModel>? {
        liveDataLogin = LoginRepository.getLoginDetails(context, strUsername)
        return liveDataLogin
    }
}