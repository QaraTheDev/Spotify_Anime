package com.example.spotifyanime.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email : String? = null
    var password : String? = null
    var name : String? = null
    var confirmPassword : String? = null

    var authListener : AuthListener? = null


    fun onLoginButtonClick(view: View) {

        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }
        authListener?.onStarted()
        authListener?.onSuccess()
    }

    fun onSignButtonClick(view: View){

        if (email.isNullOrEmpty() || password.isNullOrEmpty() || name.isNullOrEmpty() || confirmPassword.isNullOrEmpty()){
            authListener?.onFailure("Something is wrong, please check")
            return
        }
        authListener?.onStarted()
        authListener?.onSuccess()
    }



    fun onLogInAccount(view: View){
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignUpAccount(view: View){
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

}