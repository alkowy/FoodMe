package com.azmarzly.authentication

interface AuthenticationRepository {
    fun signOut()
    fun signInWithEmailAndPassword(email: String, password: String) // return type?
    fun signInWithGoogle() //?
}