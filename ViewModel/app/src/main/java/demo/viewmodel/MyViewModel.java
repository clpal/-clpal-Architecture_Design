package demo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    @Override
    protected void onCleared() {
        super.onCleared();
    }

    //private MutableLiveData<List<User>> users;
    private MutableLiveData<User> users;
    User user;
   /* public MutableLiveData<List<User>> getUsers() {
        if (users==null){
            users=new MutableLiveData<List<User>>();
            loadUsers();
        }
        users.postValue(users);
        return users;

        userDetails.postValue(smsDtoList);
        return userDetails;
    }
*/


    public MutableLiveData<User> getUsers() {

        if (users==null){
            users=new MutableLiveData<User>();
            user=new User();
            loadUsers();
        }


        users.postValue(user);

        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
       // user.setName("Chhote Pal");
        users.setValue(user);

    }
}
