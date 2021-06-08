package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
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
        if(requestCode== RC_SIGN_IN){
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }
    }
    private fun handleResult(completedTask: Task<GoogleSignInAccount>){
        try {
            val account: GoogleSignInAccount? =completedTask.getResult(ApiException::class.java)
            if (account != null) {
                updateUI(account)
            }
        } catch (e: ApiException){
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
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
                FirebaseApp.initializeApp(requireContext())

                lazySignUp.setOnClickListener {
                    signInGoogle()
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
    private fun updateUI(account: GoogleSignInAccount){
        val credential= GoogleAuthProvider.getCredential(account.idToken,null)
        auth.signInWithCredential(credential).addOnCompleteListener {task->
            if(task.isSuccessful) {
                val i = Intent(context, AppActivity::class.java)
                startActivity(i)
            }
        }
    }
    private  fun signInGoogle(){

        val signInIntent: Intent =googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }



    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null || GoogleSignIn.getLastSignedInAccount(context)!=null) {
            val i = Intent(context, AppActivity::class.java)
            startActivity(i)
        }
    }
}