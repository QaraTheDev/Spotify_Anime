package com.example.spotifyanime.ui.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotifyanime.Resource
import com.example.spotifyanime.data.repositories.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var email : String? = null
    var password : String? = null
    var name : String? = null
    var confirmPassword : String? = null


//    fun onLoginButtonClick(view: View) {
//
//        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
//            authListener?.onFailure("Invalid email or password")
//            return
//        }
//        authListener?.onStarted()
//        authListener?.onSuccess()
//    }
//
//    fun onSignButtonClick(view: View){
//
//        if (email.isNullOrEmpty() || password.isNullOrEmpty() || name.isNullOrEmpty() || confirmPassword.isNullOrEmpty()){
//            authListener?.onFailure("Something is wrong, please check")
//            return
//        }
//        authListener?.onStarted()
//        authListener?.onSuccess()
//    }

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signUpFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signUpFlow: StateFlow<Resource<FirebaseUser>?> = _signUpFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null){
            _loginFlow.value = Resource.Success(repository.currentUser!!)
        }
    }


    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading

        val result = repository.login(email, password)
        _loginFlow.value = result

    }

    fun signUp(name: String, email: String, password: String) = viewModelScope.launch {
        _signUpFlow.value = Resource.Loading

        val result = repository.signUp(name, email, password)
        _signUpFlow.value = result

    }

    fun logout(){
        repository.logout()
        _loginFlow.value = null
        _signUpFlow.value = null
    }

//    fun onLogInAccount(view: View){
//        Intent(view.context, LoginActivity::class.java).also {
//            view.context.startActivity(it)
//        }
//    }
//
//    fun onSignUpAccount(view: View){
//        Intent(view.context, SignUpActivity::class.java).also {
//            view.context.startActivity(it)
//        }
//    }
}