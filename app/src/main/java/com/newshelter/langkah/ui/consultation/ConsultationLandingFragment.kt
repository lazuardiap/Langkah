package com.newshelter.langkah.ui.consultation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentConsultationLandingBinding


class ConsultationLandingFragment : Fragment() {

    private lateinit var binding : FragmentConsultationLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConsultationLandingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){

            Glide.with(requireActivity())
                .load(R.drawable.question)
                .into(landingImg)

            btnGetStarted.setOnClickListener{
                val i = Intent(context, ConsultationActivity::class.java)
                startActivity(i)
            }
        }
    }


}