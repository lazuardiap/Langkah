package com.newshelter.langkah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.databinding.FragmentSignUpWithEmailBinding


class FragmentSignUpWithEmail : Fragment() {

    private lateinit var binding : FragmentSignUpWithEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpWithEmailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            with(binding){
                btnClose.setOnClickListener{
                    val mFragmentManager = parentFragmentManager
                    mFragmentManager.popBackStack()
                }

                btnContinue.setOnClickListener{
                    val mStep2Fragment = Step2Fragment()
                    val mFragmentManager = parentFragmentManager

                    mFragmentManager.beginTransaction().apply {
                        replace(R.id.frame_container, mStep2Fragment, Step2Fragment::class.java.simpleName)
                        addToBackStack(null)
                        commit()
                    }
                }

                signInText.setOnClickListener{
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