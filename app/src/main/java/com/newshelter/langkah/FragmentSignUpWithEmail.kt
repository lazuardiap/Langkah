package com.newshelter.langkah

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.FragmentSignUpWithEmailBinding


class FragmentSignUpWithEmail : Fragment() {

    private lateinit var binding : FragmentSignUpWithEmailBinding
    private lateinit var auth: FirebaseAuth


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

            auth = FirebaseAuth.getInstance()
            with(binding){



                btnClose.setOnClickListener{
                    val mFragmentManager = parentFragmentManager
                    mFragmentManager.popBackStack()
                }

                btnContinue.setOnClickListener{
                    val fullName = nameTf.editText?.text.toString().trim()
                    val email = emailTf.editText?.text.toString().trim()
                    val password = passwordTf.editText?.text.toString().trim()
                    val reTypePass = retypePassTf.editText?.text.toString().trim()


                    val mStep2Fragment = Step2Fragment()
                    val mFragmentManager = parentFragmentManager

                    if(fullName.isEmpty()){
                        nameTf.error ="Nama Harus di isi"
                        nameTf.requestFocus()
                        return@setOnClickListener
                    }

                    if(email.isEmpty()){
                        emailTf.error = "Email Harus di isi"
                        emailTf.requestFocus()
                        return@setOnClickListener
                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        emailTf.error = "Email tidak valid"
                        emailTf.requestFocus()
                        return@setOnClickListener
                    }
                    if(password.isEmpty() || password.length <8){
                        binding.passwordTf.error = "Password kurang dari 8 karakter"
                        binding.passwordTf.requestFocus()
                        return@setOnClickListener
                    }
                    if(reTypePass != password){
                        binding.retypePassTf.error ="Tidak Sama dengan kolom Password"
                        binding.retypePassTf.requestFocus()
                        return@setOnClickListener
                    }

                    Log.d(fullName,"massage")
                    Log.d(email,"massage")
                    Log.d(password,"massage")
                    Log.d(reTypePass,"massage")

                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                mFragmentManager.beginTransaction().apply {
                                    replace(R.id.frame_container, mStep2Fragment, Step2Fragment::class.java.simpleName)
                                    addToBackStack(null)
                                    commit()
                                }
                            }else{
                                Toast.makeText(
                                    context,
                                    "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
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