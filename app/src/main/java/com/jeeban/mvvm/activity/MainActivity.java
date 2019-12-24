package com.jeeban.mvvm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jeeban.mvvm.R;
import com.jeeban.mvvm.databinding.ActivityMainBinding;
import com.jeeban.mvvm.model.User;
import com.jeeban.mvvm.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setLoginViewModel(new LoginViewModel());
        binding.executePendingBindings();
    }

    @BindingAdapter({"bind:loginStatus", "bind:userData"})
    public static void showToastMessage(View view, boolean loginStatus, User user){
        if (loginStatus) {
            System.out.println("userr true====" + user);
        }else {
            System.out.println("userr false====" + user);
        }
    }
}
