package com.newshelter.langkah.ui.consultation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.newshelter.langkah.databinding.FragmentConsultationBinding
import java.nio.ByteBuffer


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
              //  binding.textDashboard.text = it

                val ints = intArrayOf(1,1,1)
                val bytes = ints.foldIndexed(ByteArray(ints.size)) { i, a, v -> a.apply { set(i, v.toByte()) } }

       //         val byteBuffer = ByteBuffer.wrap(bytes)

         //       val model = DiseasePredictModel.newInstance(requireContext())

// Creates inputs for reference.
         //       val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 132), DataType.FLOAT32)
//                inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
           //     val outputs = model.process(inputFeature0)
             //   val outputFeature0 = outputs.outputFeature0AsTensorBuffer


                binding.textDashboard.text = bytes.toString()
// Releases model resources if no longer used.
     //           model.close()



            })
        }
    }

    private fun intToBytes(i: Int): ByteArray? {
        val bb = ByteBuffer.allocate(4)
        bb.putInt(i)
        return bb.array()
    }


    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun convertIntArrayToByteArray(data: IntArray?): ByteArray? {
        if (data == null) return null
        // ----------
        val byts = ByteArray(data.size * 4)
        for (i in data.indices) System.arraycopy(intToBytes(data[i]), 0, byts, i * 132, 132)
        return byts
    }
}