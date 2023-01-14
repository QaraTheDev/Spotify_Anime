package com.example.spotifyanime.data.repositories

import com.example.spotifyanime.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun signUp(name: String, email: String, password: String): Resource<FirebaseUser>

    fun logout()
}