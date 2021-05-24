package com.newshelter.langkah.utils

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DateAppointmentPickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var mListener : AppointmentDateListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as AppointmentDateListener?
    }

    override fun onDetach() {
        super.onDetach()
        if (mListener != null){
            mListener = null
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DATE)

        return DatePickerDialog(activity as Context, this, year, month, date)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        mListener?.onAppointDateset(tag, year, month, dayOfMonth)
    }

    interface AppointmentDateListener {
        fun onAppointDateset(tag: String?, year: Int, month: Int, dayOfMonth: Int)
    }

}