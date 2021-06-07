package com.newshelter.langkah.ui.consultation

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.newshelter.langkah.AppActivity
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityConsultationResultBinding
import com.newshelter.langkah.utils.DataDummy
import com.newshelter.langkah.utils.DateAppointmentPickerFragment
import com.newshelter.langkah.utils.TimePickerFragment
import java.text.SimpleDateFormat
import java.util.*

class ConsultationResultActivity : AppCompatActivity(), DateAppointmentPickerFragment.AppointmentDateListener, TimePickerFragment.DialogTimeListener {

    private lateinit var binding : ActivityConsultationResultBinding

    companion object{
        const val EXTRA_SYMPTOMS = "extra_symptoms"

        private const val DATE_PICKER_TAG = "DatePicker"
        private const val TIME_PICKER_TAG = "TimePickerOnce"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val previousActivity = ConsultationActivity()

        val dummyHospital = DataDummy.generateDummyHospital()

        with(binding){
            tvSymptom.text = extras?.getString(EXTRA_SYMPTOMS)

            tvHospitalName.text = dummyHospital[0].hospitalName

            tvHospitalAddress.text = dummyHospital[0].address

            tvPolyName.text = dummyHospital[0].polyclinics[0].polyName

            btnAppointmentDate.setOnClickListener{
                val datepicker = DateAppointmentPickerFragment()
                datepicker.show(supportFragmentManager, DATE_PICKER_TAG)
            }

            btnAppointmentTime.setOnClickListener {
                val timePickerFragment = TimePickerFragment()
                timePickerFragment.show(supportFragmentManager, TIME_PICKER_TAG)
            }

            btnMakeAppointment.setOnClickListener {
                val builder = AlertDialog.Builder(this@ConsultationResultActivity)
                builder.setTitle("Make Appointment")
                builder.setMessage("Are you sure you want to make the appointment?")

                builder.setPositiveButton(R.string.yes) { dialog, which ->
                    finish()
                    val i = Intent(this@ConsultationResultActivity, AppActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(i)
                    Toast.makeText(this@ConsultationResultActivity, "Your appointment is made!", Toast.LENGTH_SHORT).show()
                }

                builder.setNegativeButton(R.string.no) { dialog, which ->
                    Toast.makeText(this@ConsultationResultActivity, "Please press skip button", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }

            btnSkipAppointment.setOnClickListener {
                val builder = AlertDialog.Builder(this@ConsultationResultActivity)
                builder.setTitle("Skip Appointment")
                builder.setMessage("Are you sure you want to skip the appointment?")

                builder.setPositiveButton(R.string.yes) { dialog, which ->
                    finish()
                    val i = Intent(this@ConsultationResultActivity, AppActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(i)
                    Toast.makeText(this@ConsultationResultActivity, "Your appointment is skipped!", Toast.LENGTH_SHORT).show()
                }

                builder.setNegativeButton(R.string.no) { dialog, which ->
                    Toast.makeText(this@ConsultationResultActivity, "Please make the appointment", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }

        }
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