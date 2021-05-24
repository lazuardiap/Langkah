package com.newshelter.langkah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.newshelter.langkah.databinding.FragmentLandingBinding

class FragmentLanding : Fragment() {

    private lateinit var binding : FragmentLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingBinding.inflate(layoutInflater)
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

}