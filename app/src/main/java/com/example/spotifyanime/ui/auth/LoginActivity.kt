package com.example.spotifyanime.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyanime.R
import com.example.spotifyanime.databinding.ActivityLoginBinding
import com.example.spotifyanime.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        viewModel.authListener = this

    }

    override fun onStarted() {
        toast("Login Started!")
    }

    override fun onSuccess() {
        toast("Login Success!")
    }

    override fun onFailure(message : String) {
        toast(message)
    }

}