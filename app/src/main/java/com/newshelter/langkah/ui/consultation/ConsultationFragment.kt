package com.newshelter.langkah.ui.consultation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentConsultationBinding


class ConsultationFragment : Fragment() {

    private lateinit var binding : FragmentConsultationBinding
    private lateinit var viewModel: ConsultationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConsultationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            viewModel = ConsultationViewModel()
            viewModel.text.observe(viewLifecycleOwner, Observer {
                binding.textDashboard.text = it
            })
        }
    }


}