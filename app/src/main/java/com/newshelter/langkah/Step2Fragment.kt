package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.FragmentStep2Binding

class Step2Fragment : Fragment() {

    private lateinit var binding: FragmentStep2Binding
    private lateinit var auth: FirebaseAuth

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStep2Binding.inflate(layoutInflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            with(binding) {
                btnBack.setOnClickListener {
                    val mFragmentManager = parentFragmentManager
                    mFragmentManager.popBackStack()
                }

                btnSignUp.setOnClickListener {
                    val i = Intent(context, AppActivity::class.java)
                    startActivity(i)
                }

                val user = auth.currentUser
                val phone = phoneTf.editText?.text.toString()
                val address = addressTf.editText?.text.toString()

                if(user!= null){
                    if(phone.isEmpty()){
                        phoneTf.error = "nomor telepon harus di isi"
                        phoneTf.requestFocus()
                        return
                    }
                    phoneTf.editText?.setText(user.phoneNumber)

                }
            }
        }
    }

}