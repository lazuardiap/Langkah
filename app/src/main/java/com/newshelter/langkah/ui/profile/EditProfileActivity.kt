package com.newshelter.langkah.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.databinding.ActivityEditProfileBinding
import com.newshelter.langkah.utils.DataDummy

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditProfileBinding

    companion object{
        const val EXTRA_USER_ID = "extra_user_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        val dummyUser = DataDummy.generateDummyUser()

        if (extras != null){

            with(binding){

                for(user in dummyUser){
                    if (user.userId == extras.getString(EXTRA_USER_ID)){
                        tvUserName.setText(user.userFullName)
                        tvUserEmail.setText(user.userEmail)
                        tvUserAddress.setText(user.homeAddress)
                        tvUserPhone.setText(user.phoneNumber)
                    }
                }
            }
        }
    }
}