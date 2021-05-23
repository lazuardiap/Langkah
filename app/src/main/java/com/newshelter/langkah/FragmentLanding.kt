package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.FragmentLandingBinding

class FragmentLanding : Fragment() {

    private lateinit var binding : FragmentLandingBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            with(binding){

                Glide.with(requireActivity())
                    .load(R.drawable.around_location)
                    .into(landingImg)



                signUpButton.setOnClickListener{
                    val mFragmentSignUpWithEmail = FragmentSignUpWithEmail()
                    val mFragmentManager = fragmentManager

                    mFragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_container, mFragmentSignUpWithEmail, FragmentSignUpWithEmail::class.java.simpleName)
                        addToBackStack(null)
                        commit()
                    }

                }

                signInText.setOnClickListener {
                    val mFragmentSignIn = LoginFragment()
                    val mFragmentManager = fragmentManager

                    mFragmentManager?.beginTransaction()?.apply {
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