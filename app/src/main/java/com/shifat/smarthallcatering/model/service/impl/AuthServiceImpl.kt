package com.shifat.smarthallcatering.model.service.impl


 import androidx.compose.ui.util.trace
 import com.google.firebase.auth.EmailAuthProvider
 import com.google.firebase.auth.FirebaseAuth
 import com.shifat.smarthallcatering.model.service.AuthService
 import com.shifat.smarthallcatering.model.user.User
 import kotlinx.coroutines.channels.awaitClose
 import kotlinx.coroutines.flow.Flow
 import kotlinx.coroutines.flow.callbackFlow
 import kotlinx.coroutines.tasks.await
 import javax.inject.Inject

class AuthServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthService {

    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override val hasUser: Boolean
        get() = auth.currentUser != null

    override val currentUser: Flow<User>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(auth.currentUser?.let { User(it.uid) } ?: User())
                }
            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }

    override suspend fun authenticate(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }


    override suspend fun sendRecoveryEmail(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }


    override suspend fun registerUser(email: String, password: String): Unit =
        trace(LINK_ACCOUNT_TRACE) {
            val credential = EmailAuthProvider.getCredential(email, password)
            auth.createUserWithEmailAndPassword(email, password).await()
        }


    override suspend fun signOut() {
        if (auth.currentUser!!.isAnonymous) {
            auth.currentUser!!.delete()
        }
        auth.signOut()
    }

    companion object {
        private const val LINK_ACCOUNT_TRACE = "linkAccount"
    }
}
