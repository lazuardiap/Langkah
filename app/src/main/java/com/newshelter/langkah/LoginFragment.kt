package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            with(binding){

                btnClose.setOnClickListener{
                    val mFragmentManager = fragmentManager
                    mFragmentManager?.popBackStack()
                }

                signInBtn.setOnClickListener{
                    val i = Intent(context, AppActivity::class.java)
                    startActivity(i)
                }

            }
        }
    }


}