package com.example.spotifyanime.data.repositories

import com.example.spotifyanime.Resource
import com.example.spotifyanime.data.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result?.user?.updateProfile(
                UserProfileChangeRequest
                    .Builder()
                    .setDisplayName(name)
                    .build()
            )?.await()
            Resource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}