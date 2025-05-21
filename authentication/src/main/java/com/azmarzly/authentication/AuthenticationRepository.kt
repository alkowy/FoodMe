package com.azmarzly.authentication

interface AuthenticationRepository {
    fun signInWithEmailAndPassword(email: String, password: String) // return type?
    fun signInWithGoogle() // return type?
    fun signOut() // return type?
    fun isSignedIn(): Boolean
    fun signUpWithEmailAndPassword(email: String, password: String)// return type?
    fun resetPassword(email: String) // return type?
    fun forgotPassword(email: String) // return type
}