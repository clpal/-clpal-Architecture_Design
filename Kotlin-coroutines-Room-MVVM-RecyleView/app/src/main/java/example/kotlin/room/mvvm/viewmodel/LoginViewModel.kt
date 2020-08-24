package example.kotlin.room.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.kotlin.room.mvvm.model.LoginTableModel
import example.kotlin.room.mvvm.repository.LoginRepository
import example.kotlin.room.mvvm.view.MainActivity

class LoginViewModel : ViewModel() {
    var liveDataLogin: LiveData<List<LoginTableModel>>? = null
    fun insertData(context: Context, username: String, phone: String) {
        LoginRepository.insertData(context, username, phone)
    }

    fun getLoginDetails(context: MainActivity, strUsername: String): LiveData<List<LoginTableModel>>? {
        liveDataLogin = LoginRepository.getLoginDetails(context, strUsername)
        return liveDataLogin
    }
   fun  getAllUses(context: MainActivity):LiveData<List<LoginTableModel>>?{
        liveDataLogin=LoginRepository.getAllUsers(context)
        return liveDataLogin
    }
}