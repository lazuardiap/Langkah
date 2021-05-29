package com.newshelter.langkah

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.newshelter.langkah.databinding.FragmentLandingBinding


class FragmentLanding : Fragment() {

    private lateinit var binding : FragmentLandingBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient :GoogleSignInClient

    companion object{
        private const val RC_SIGN_IN = 666
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            if(task.isSuccessful){
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    Log.w(TAG, "Google sign in failed", e)
                }
            }else{
                Log.w(TAG, "Google sign in failed")
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLandingBinding.inflate(layoutInflater)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(),gso)

        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            with(binding){
                lazySignUp.setOnClickListener {
                    val googleIntent = googleSignInClient.signInIntent
                    startActivityForResult(googleIntent, RC_SIGN_IN)

                    val mStep2Fragment = Step2Fragment()
                    val mFragmentManager = parentFragmentManager

                    mFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.frame_container,
                            mStep2Fragment,
                            Step2Fragment::class.java.simpleName
                        )
                        addToBackStack(null)
                        commit()
                    }

                }
                Glide.with(requireActivity())
                    .load(R.drawable.around_location)
                    .into(landingImg)

                signUpButton.setOnClickListener{
                    val mFragmentSignUpWithEmail = FragmentSignUpWithEmail()
                    val mFragmentManager = parentFragmentManager

                    mFragmentManager.beginTransaction().apply {
                        replace(R.id.frame_container, mFragmentSignUpWithEmail, FragmentSignUpWithEmail::class.java.simpleName)
                        addToBackStack(null)
                        commit()
                    }
                }
                signInText.setOnClickListener {
                    val mFragmentSignIn = LoginFragment()
                    val mFragmentManager = parentFragmentManager

                    mFragmentManager.beginTransaction().apply {
                        replace(R.id.frame_container, mFragmentSignIn, LoginFragment::class.java.simpleName)
                        addToBackStack(null)
                        commit()
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            val i = Intent(context, AppActivity::class.java)
            startActivity(i)
        }
    }
}