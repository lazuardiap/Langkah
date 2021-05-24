package com.newshelter.langkah.ui.appointment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityAppointmentBinding
import com.newshelter.langkah.utils.DataDummy
import com.newshelter.langkah.utils.DateAppointmentPickerFragment
import com.newshelter.langkah.utils.DatePickerFragment
import com.newshelter.langkah.utils.TimePickerFragment
import java.text.SimpleDateFormat
import java.util.*

class AppointmentActivity : AppCompatActivity(),
    DatePickerFragment.DialogDateListener, DateAppointmentPickerFragment.AppointmentDateListener, TimePickerFragment.DialogTimeListener {

    private lateinit var binding : ActivityAppointmentBinding


    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"

        private const val DATE_PICKER_TAG = "DatePicker"
        private const val TIME_PICKER_TAG = "TimePickerOnce"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            val hospitaldummy = DataDummy.generateDummyHospital()

            val extras = intent.extras

            val items = ArrayList<String>()

            Glide.with(this@AppointmentActivity)
                .load(R.drawable.booking)
                .into(appointImg)

            btnOnceDate.setOnClickListener{
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)

            }

            btnAppointmentDate.setOnClickListener{
                val datepicker = DateAppointmentPickerFragment()
                datepicker.show(supportFragmentManager, DATE_PICKER_TAG)
            }

            btnAppointmentTime.setOnClickListener {
                val timePickerFragment = TimePickerFragment()
                timePickerFragment.show(supportFragmentManager, TIME_PICKER_TAG)
            }


            for (hospital in hospitaldummy){
                if (hospital.hospitalId == extras?.getString(EXTRA_HOSPITAL_ID)){
                    val polys = hospital.polyclinics
                    for (i in polys){
                        items.add(i.polyName)
                    }
                }
            }

            val adapter = ArrayAdapter(applicationContext, R.layout.dropdown_item, items)
            (hospitalMenu.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.tvOnceDate.text = dateFormat.format(calendar.time)
    }

    override fun onAppointDateset(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.tvAppointmentDate.text = dateFormat.format(calendar.time)
    }

    override fun onDialogTimeSet(tag: String?, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)

        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        binding.tvAppointmentTime.text = dateFormat.format(calendar.time)
    }

}