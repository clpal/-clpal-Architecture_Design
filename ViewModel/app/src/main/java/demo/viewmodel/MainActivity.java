package demo.viewmodel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tvtext);
        TextView designation = findViewById(R.id.designation);
        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance created by the first activity.

        final MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);

        model.getUsers().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {

                // update UI

                textView.setText("My Name is : " + user.getName());


            }
        });
        model.getUsers().observe(this, user -> {
            // update UI
            designation.setText("My Designation is : " + user.getDesignation());
        });
        model.onCleared();
    }
}