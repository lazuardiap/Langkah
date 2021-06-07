package com.newshelter.langkah.ui.consultation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentConsultationBinding
import com.newshelter.langkah.ml.DiseasePredictModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer


class ConsultationFragment : Fragment() {

    private lateinit var binding: FragmentConsultationBinding
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

        if (activity != null) {
            viewModel = ConsultationViewModel()
            mlMdel()
            viewModel.text.observe(viewLifecycleOwner, {
                //  binding.textDashboard.text = it









                //       val data = intArrayOf(
                ///           1,1,1,1,1,1,1
                //         )
                //         val byteBuffer = ByteBuffer.allocate(132)


                //       val intBuffer: IntBuffer = byteBuffer.asIntBuffer()
                //       intBuffer.put(data)
                //           .asReadOnlyBuffer()

                //       val array = byteBuffer.array()
                //   for (i in array.indices) {
                //     Log.d(context.toString(),i.toString() + ": " + array[i])
                //    }
                //   Log.d(context.toString(), array[1].toString() + array.toString()+ array.size.toString())
                //          val asd =
                //               ByteBuffer.wrap(array)

                //        Log.d(context.toString(), asd.char.toString() + asd.toString())


                //      val model = DiseasePredictModel.newInstance(requireContext())

// Creates inputs for reference.

                //         val input = TensorBuffer.createFixedSize(intArrayOf(1, 1, 132),DataType.FLOAT32)
                //            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 132), DataType.FLOAT32)
                //          inputFeature0.loadBuffer(asd, intArrayOf(1,1,132))
//
// Runs model inference and gets result.

                //     val outputs = model.process(inputFeature0)
                //      val outputFeature0 = outputs.outputFeature0AsTensorBuffer

                //      Log.d(context.toString(),outputFeature0.toString())
                //      binding.textDashboard.text = outputFeature0.toString()
                //      model.close()


                //         val ints = intArrayOf(1,1,1)
//                val bytes = ints.foldIndexed(ByteArray(ints.size)) { i, a, v ->
                //            a.apply {
                //                set(i, v.toByte())
                //             }
                //          }
/*
                var i = 0

                val array:ByteArray = byteArrayOf(1,1)
                while (i<132){
                    val asd = ints.foldIndexed(ByteArray(ints.size)){index,acc,value ->
                        acc.apply {
                            set(1, 1.toByte())
                        }
                    }
                    val ade = 1
                    Log.d(context.toString(),asd[ade].toString())
                    array.plus(asd)
                    Log.d(context.toString(),array.size.toString())
                    Log.d(context.toString(),array.toString())
                    i++
                    Log.d(context.toString(),array.toString())
                    binding.textDashboard.text = array.toString()
                    Log.d(context.toString(),array.size.toString())
                }

             //   val asd = ints.foldIndexed(ByteArray(ints.size)){index,acc,value ->
            //        acc.apply {
           //             set(1, 1.toByte())
           //         }
          //      }
          //      Log.d(context.toString(),asd[0].toString())
         //       Log.d(context.toString(),asd[1].toString())
         //       Log.d(context.toString(),asd[2].toString())

       //         val byteBuffer = ByteBuffer.wrap(bytes)

         //       val model = DiseasePredictModel.newInstance(requireContext())

// Creates inputs for reference.
         //       val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 132), DataType.FLOAT32)
//                inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
           //     val outputs = model.process(inputFeature0)
             //   val outputFeature0 = outputs.outputFeature0AsTensorBuffer


             //   binding.textDashboard.text = bytes.toString()
// Releases model resources if no longer used.
     //           model.close()



 */

            })
        }
    }


    private fun mlMdel() {

        val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*132)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(1f)
        byteBuffer.putFloat(0f)
        byteBuffer.putFloat(0f)









        val model = DiseasePredictModel.newInstance(requireContext())

// Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 132), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)


// Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray






        val maxIndex = outputFeature0.indices.maxByOrNull { outputFeature0[it] }

        when(maxIndex){

            0-> {
                binding.textDashboard.text = getString(R.string.vertigo)
            }
            1-> {
                binding.textDashboard.text = getString(R.string.aids)
            }
            2-> {
                binding.textDashboard.text = getString(R.string.acne)
            }
            3-> {
                binding.textDashboard.text = getString(R.string.alcohepa)
            }
            4-> {
                binding.textDashboard.text = getString(R.string.allergy)
            }
            5-> {

                binding.textDashboard.text = getString(R.string.arthritis)
            }
            6-> {
                binding.textDashboard.text = getString(R.string.bronc_asthma)
            }
            7-> {
                binding.textDashboard.text = getString(R.string.Cervical_Spondylosis)
            }
            8-> {
                binding.textDashboard.text = getString(R.string.Chicken_P)
            }
            9-> {
                binding.textDashboard.text = getString(R.string.Chronic_Choles)
            }
            10-> {
                binding.textDashboard.text = getString(R.string.common_cold)
            }
            11-> {
                binding.textDashboard.text = getString(R.string.dengue)
            }
            12-> {
                binding.textDashboard.text = getString(R.string.diabet)
            }
            13-> {
                binding.textDashboard.text = getString(R.string.piles)
            }
            14-> {
                binding.textDashboard.text = getString(R.string.drug_react)
            }
            15-> {
                binding.textDashboard.text = getString(R.string.fungal_infect)
            }
            16-> {
                binding.textDashboard.text = getString(R.string.gerd)
            }
            17-> {
                binding.textDashboard.text = getString(R.string.gastroenter)
            }
            18-> {
                binding.textDashboard.text = getString(R.string.heart_attak)
            }
            19-> {
                binding.textDashboard.text = getString(R.string.hepatitis_B)
            }
            20-> {
                binding.textDashboard.text = getString(R.string.Hepatitis_C)
            }
            21-> {
                binding.textDashboard.text = getString(R.string.Hepatitis_D)
            }
            22-> {
                binding.textDashboard.text = getString(R.string.Hepatitis_E)
            }
            23-> {
                binding.textDashboard.text = getString(R.string.Hpertensi)
            }
            24-> {
                binding.textDashboard.text = getString(R.string.Hperthroid)
            }
            25-> {
                binding.textDashboard.text = getString(R.string.Hypogy)
            }
            26-> {
                binding.textDashboard.text = getString(R.string.hypothiroid)
            }
            27-> {
                binding.textDashboard.text = getString(R.string.impetigo)
            }
            28-> {
                binding.textDashboard.text = getString(R.string.jaundice)
            }
            29-> {
                binding.textDashboard.text = getString(R.string.malaria)
            }
            30-> {
                binding.textDashboard.text = getString(R.string.migraine)
            }
            31-> {
                binding.textDashboard.text = getString(R.string.osteorarthirs)
            }
            32-> {
                binding.textDashboard.text = getString(R.string.paralysis)
            }
            33-> {
                binding.textDashboard.text = getString(R.string.peptic_ulcer)
            }
            34-> {
                binding.textDashboard.text = getString(R.string.pneumonia)
            }
            35-> {
                binding.textDashboard.text = getString(R.string.psoriasis)
            }
            36-> {
                binding.textDashboard.text = getString(R.string.tbc)
            }
            37-> {
                binding.textDashboard.text = getString(R.string.typhoid)
            }
            38-> {
                binding.textDashboard.text = getString(R.string.urinary_tract)
            }
            39-> {
                binding.textDashboard.text = getString(R.string.varicose_vens)
            }
            40-> {
                binding.textDashboard.text = getString(R.string.hepatitis_A)
            }
            else -> {
                binding.textDashboard.text = getString(R.string.error)
            }
        }

        Log.d(context.toString(), maxIndex.toString())
        Log.d(context.toString(),outputFeature0.size.toString())

     //   Log.d(context.toString(), outputFeature0.maxOrNull().toString())
     //   Log.d(context.toString(), outputFeature0.minOrNull().toString())

      //  Log.d(context.toString(),max.toString()+"max")
     //   Log.d(context.toString(),min.toString()+"min")
// Releases model resources if no longer used.
        model.close()
    }


}



