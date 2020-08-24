package example.kotlin.room.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import example.kotlin.room.mvvm.model.LoginTableModel
import example.kotlin.room.mvvm.room.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LoginRepository {
    companion object {
        var loginDatabase: LoginDatabase? = null
        internal var loginTableModel: LiveData<List<LoginTableModel>>? = null
        fun initializeDB(context: Context): LoginDatabase {
            return LoginDatabase.getDatabaseClient(context)
        }

        fun insertData(context: Context, username: String, phone: String) {
            loginDatabase = initializeDB(context)
            CoroutineScope(Dispatchers.IO).async {
                val loginDetails = LoginTableModel(username, phone)
                loginDatabase!!.loginDao().InsertData(loginDetails)
            }
        }

        fun getLoginDetails(context: Context, username: String): LiveData<List<LoginTableModel>>? {
            loginDatabase = initializeDB(context)

            loginTableModel = loginDatabase!!.loginDao().getLoginDetails(username)
            return loginTableModel
        }

        fun getAllUsers(context: Context): LiveData<List<LoginTableModel>> {

                loginDatabase = initializeDB(context)
                loginTableModel = loginDatabase!!.loginDao().allUsers()


            return loginTableModel as LiveData<List<LoginTableModel>>
        }
    }
}