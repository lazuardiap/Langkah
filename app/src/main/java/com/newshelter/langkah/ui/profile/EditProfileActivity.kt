package com.newshelter.langkah.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.databinding.ActivityEditProfileBinding
import com.newshelter.langkah.ui.appointment.AppointmentActivity
import com.newshelter.langkah.utils.DataDummy
import com.newshelter.langkah.utils.DatePickerFragment
import java.text.SimpleDateFormat
import java.util.*

class EditProfileActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener {

    private lateinit var binding : ActivityEditProfileBinding

    companion object{
        const val EXTRA_USER_ID = "extra_user_id"

        private const val DATE_PICKER_TAG = "DatePicker"
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

                        if (user.homeAddress != ""){
                            tvUserAddress.setText(user.homeAddress)
                        }

                        if (user.phoneNumber != ""){
                            tvUserPhone.setText(user.phoneNumber)
                        }

                        if (user.userBirthdate != ""){
                            tvOnceDate.setText(user.userBirthdate)
                        }
                    }
                }

                btnOnceDate.setOnClickListener{
                    val datePickerFragment = DatePickerFragment()
                    datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG
                    )

                }
            }
        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.tvOnceDate.text = dateFormat.format(calendar.time)
    }
}