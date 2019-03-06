package edu.cascadia.mobile.apps.passwordcheck;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.cascadia.mobile.apps.passwordcheck.databinding.ActivityMainBinding;
//5. Update the MainActivity
//
//    Remove new PasswordViewModel() instance
//    Instead use the ViewModelProviders.of() syntax to get a reference to the persistent ViewModel
//    Call the binding setLifeCycleOwner method and pass it the ViewModel reference
public class MainActivity extends AppCompatActivity {

    //TODO: create a private ViewModel instance variable
private PasswordViewModel mPasswordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Comment out the setContentView - we'll use a binding instead
       // setContentView(R.layout.activity_main);
      //  Remove new PasswordViewModel() instance
//    Instead use the ViewModelProviders.of() syntax to get a reference to the persistent ViewModel
mPasswordViewModel = ViewModelProviders.of(this).get(PasswordViewModel.class);

        //TODO: Create a new binding using DataBindingUtil
//ActivityMainBinding binding = DataBindingUtil.setContentView(R.layout.activity_main);
        //TODO: Create a new PasswordViewModel object

        //TODO: Set the binding's ViewModel to your new PasswordViewModel


    }
}
