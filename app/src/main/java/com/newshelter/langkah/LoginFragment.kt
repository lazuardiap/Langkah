package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

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
        auth = FirebaseAuth.getInstance()

        if (activity != null){
            with(binding){

                btnClose.setOnClickListener{
                    val mFragmentManager = parentFragmentManager
                    mFragmentManager.popBackStack()
                }

                signInBtn.setOnClickListener{
                    val email = emailTf.editText?.text.toString().trim()
                    val password = passwordTf.editText?.text.toString().trim()

                    if(email.isEmpty()){
                        emailTf.error = "Email harus di isi"
                        emailTf.requestFocus()
                        return@setOnClickListener
                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        emailTf.error = "Email tidak valid"
                        emailTf.requestFocus()
                        return@setOnClickListener
                    }
                    if(password.isEmpty() || password.length < 8){
                        passwordTf.error = "Password harus di isi 8 karakter"
                        passwordTf.requestFocus()
                        return@setOnClickListener
                    }
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                val i = Intent(context, AppActivity::class.java)
                                startActivity(i)
                            }else{
                                Toast.makeText(context, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }
    }


}