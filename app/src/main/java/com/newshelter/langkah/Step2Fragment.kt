package com.newshelter.langkah

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.databinding.FragmentStep2Binding
import com.newshelter.langkah.utils.DatePickerFragment
import java.text.SimpleDateFormat
import java.util.*

class Step2Fragment : Fragment() {

    private lateinit var binding: FragmentStep2Binding

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStep2Binding.inflate(layoutInflater, container, false)
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
            }
        }
    }

}