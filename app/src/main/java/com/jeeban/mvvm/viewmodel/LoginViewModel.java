package com.jeeban.mvvm.viewmodel;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.jeeban.mvvm.model.User;

public class LoginViewModel extends BaseObservable {

    private User user;
    private boolean loginStatus;

    public LoginViewModel() {
        user = new User();
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }


    @Bindable
    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
        notifyPropertyChanged(BR.loginStatus);
    }

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    public void onLoginClicked(){
        if (isLoginValidate()){
           setUser(this.user);
           setLoginStatus(true);
        }else {
            setUser(this.user);
            setLoginStatus(false);
        }
    }

    public boolean isLoginValidate(){
        return !TextUtils.isEmpty(user.getEmail()) && !TextUtils.isEmpty(user.getPassword());
    }

}
