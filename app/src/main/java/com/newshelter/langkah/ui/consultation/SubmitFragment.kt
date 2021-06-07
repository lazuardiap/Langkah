package com.newshelter.langkah.ui.consultation

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentSubmitBinding


class SubmitFragment : Fragment() {

    private lateinit var binding : FragmentSubmitBinding

    companion object{
        const val EXTRA_SYMPTOM = "extra_symptoms"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSubmitBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val i = Intent(context, ConsultationResultActivity::class.java)
            i.putExtra(ConsultationResultActivity.EXTRA_SYMPTOMS, arguments?.getString(EXTRA_SYMPTOM))
            startActivity(i)
        }

        binding.btnClose.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Cancel Consultation")
            builder.setMessage("Are you sure you want to cancel your consultation process?")

            builder.setPositiveButton(R.string.yes) { dialog, which ->
                activity?.finish()
                Toast.makeText(context, "Your consultation is cancelled", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(R.string.no) { dialog, which ->
                Toast.makeText(context, "Resuming your consultation", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

//        binding.tvSymptom.text = arguments?.getString(EXTRA_SYMPTOM)
    }


}