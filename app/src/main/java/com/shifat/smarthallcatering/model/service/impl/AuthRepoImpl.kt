//package com.shifat.smarthallcatering.model.service.impl
//
//import android.net.Uri
//import android.util.Log
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.UserProfileChangeRequest
//import com.shifat.smarthallcatering.data.Resource
//import com.shifat.smarthallcatering.data.utils.await
//import com.shifat.smarthallcatering.model.service.AuthRepository
//import com.shifat.smarthallcatering.model.user.UserType
//import javax.inject.Inject
//
//// Where Data Retrievation or Data Manipulation is done in Database
//
//class AuthRepoImpl @Inject constructor(
//    private  val firebaseAuth: FirebaseAuth
//) : AuthRepository {
//    override val currentUser: FirebaseUser?
//        get() = firebaseAuth.currentUser
//
//     val currentUserId: String
//        get() = firebaseAuth.currentUser?.uid.orEmpty()
//
//    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
//      return  try {
//            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
//            Log.d("chuda",currentUserId)
//          Resource.Success(result?.user!!)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return Resource.Failure(e)
//        }
//    }
//
//
//
//
//    override suspend fun signup(
//        name: String,
//        email: String,
//        password: String,
//        phone: String,
//        userType: UserType,
//        imageUri: Uri?
//    ): Resource<FirebaseUser> {
//        return try {
//            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
//            Log.d("AuthRepositoryImpl", "signup: $result")
//            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
//            Resource.Success(result?.user!!)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Resource.Failure(e)
//        }
//    }
//
//    override fun logout(): Resource<String> {
//        TODO("Not yet implemented")
//    }
//}