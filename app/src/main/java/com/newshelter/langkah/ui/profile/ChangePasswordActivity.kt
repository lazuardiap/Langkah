package com.newshelter.langkah.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangePasswordBinding
    private lateinit var auth:FirebaseAuth

    companion object{
        const val EXTRA_USER_ID = "extra_user_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        with(binding){
            val oldPassword = nameTf.editText?.text.toString().trim()
            val password = passwordTf.editText?.text.toString().trim()
            val rePassword = retypePassTf.editText?.text.toString().trim()


            if(oldPassword.isEmpty()){
                nameTf.error = "harus di isi"
                nameTf.requestFocus()
                return
            }
            if(password.isEmpty()){
                passwordTf.error = "harus di isi"
                passwordTf.requestFocus()
                return
            }
            if(rePassword.isEmpty()){
                retypePassTf.error = "harus di isi"
                retypePassTf.requestFocus()
                return
            }
            if(password != rePassword){
                retypePassTf.error= "isi tidak sama"
                retypePassTf.requestFocus()
                return
            }

            binding.btnChangePassword.setOnClickListener {
                auth.currentUser?.updatePassword(rePassword)
                    ?.addOnCompleteListener {
                        if(it.isSuccessful){
                            Log.d(it.isComplete.toString(),"cek")
                        }
                    }
            }
        }


    }
}