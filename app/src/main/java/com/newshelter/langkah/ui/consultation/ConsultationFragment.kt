package com.newshelter.langkah.ui.consultation

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentConsultationBinding
import com.newshelter.langkah.ml.DiseasePredictModel

import kotlinx.android.synthetic.main.fragment_consultation.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer


class ConsultationFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentConsultationBinding
    private lateinit var viewModel: ConsultationViewModel
    private var mCurrentPosition: Int = 0
    private var mQuestionList : List<String>? = null

    private val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*132)

    private lateinit var textQuestion : String

    private lateinit var textProgress : String

    private lateinit var symptomResult : String

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

            mQuestionList = viewModel.getQuestions()

            setQuestion()

            btn_true.setOnClickListener(this)
            btn_false.setOnClickListener(this)
            btn_close.setOnClickListener(this)
        }
    }

    private fun setQuestion(){


        binding.progressBar.progress = mCurrentPosition

        textProgress = mCurrentPosition.toString() + "/" + progressBar.max

        binding.tvProgress.text = textProgress

        textQuestion = "Apakah anda merasa " +mQuestionList!![mCurrentPosition]+ " ?"

        binding.tvQuestion.text = textQuestion
        mCurrentPosition++
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_true ->{
                Log.d("Success", mCurrentPosition.toString())

                val fm = parentFragmentManager
                val mSubmitFragment = SubmitFragment()
                val mBundle = Bundle()

                if (mCurrentPosition <= mQuestionList!!.size){

                    byteBuffer.putFloat(1f)

                    when{
                        mCurrentPosition < mQuestionList!!.size -> {
                            setQuestion()
                        }

                        else ->{
                            mCurrentPosition = mQuestionList!!.size - 1
                            Toast.makeText(requireContext(), "You have succesfuly finished the questionaire", Toast.LENGTH_SHORT).show()

                            symptomResult = mlModel(byteBuffer)

                            mBundle.putString(SubmitFragment.EXTRA_SYMPTOM, symptomResult)

                            mSubmitFragment.arguments = mBundle

                            fm.beginTransaction()
                                .replace(R.id.frame_container, mSubmitFragment, SubmitFragment::class.java.simpleName)
                                .commit()
                        }
                    }
                }
            }

            R.id.btn_false->{

                byteBuffer.putFloat(0f)

                val fm = parentFragmentManager
                val mSubmitFragment = SubmitFragment()
                val mBundle = Bundle()
                
                Log.d("Success", mCurrentPosition.toString())
                when{
                    mCurrentPosition < mQuestionList!!.size -> {
                        setQuestion()
                    }

                    else ->{
                        mCurrentPosition = mQuestionList!!.size - 1
                        Toast.makeText(requireContext(), "You have succesfuly finished the questionaire", Toast.LENGTH_SHORT).show()

                        symptomResult = mlModel(byteBuffer)

                        mBundle.putString(SubmitFragment.EXTRA_SYMPTOM, symptomResult)

                        mSubmitFragment.arguments = mBundle

                        fm.beginTransaction()
                            .replace(R.id.frame_container, mSubmitFragment, SubmitFragment::class.java.simpleName)
                            .commit()
                    }
                }
            }

            R.id.btn_close->{
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
        }
    }


    private fun mlModel(byteBuffer: ByteBuffer) : String{


        lateinit var symptoms : String



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
                symptoms = getString(R.string.vertigo)
            }
            1-> {
                symptoms = getString(R.string.aids)
            }
            2-> {
                symptoms = getString(R.string.acne)
            }
            3-> {
                symptoms = getString(R.string.alcohepa)
            }
            4-> {
                symptoms = getString(R.string.allergy)
            }
            5-> {

                symptoms = getString(R.string.arthritis)
            }
            6-> {
                symptoms = getString(R.string.bronc_asthma)
            }
            7-> {
                symptoms = getString(R.string.Cervical_Spondylosis)
            }
            8-> {
                symptoms = getString(R.string.Chicken_P)
            }
            9-> {
                symptoms = getString(R.string.Chronic_Choles)
            }
            10-> {
                symptoms = getString(R.string.common_cold)
            }
            11-> {
                symptoms = getString(R.string.dengue)
            }
            12-> {
                symptoms = getString(R.string.diabet)
            }
            13-> {
                symptoms = getString(R.string.piles)
            }
            14-> {
                symptoms = getString(R.string.drug_react)
            }
            15-> {
                symptoms = getString(R.string.fungal_infect)
            }
            16-> {
                symptoms = getString(R.string.gerd)
            }
            17-> {
                symptoms = getString(R.string.gastroenter)
            }
            18-> {
                symptoms = getString(R.string.heart_attak)
            }
            19-> {
                symptoms = getString(R.string.hepatitis_B)
            }
            20-> {
                symptoms = getString(R.string.Hepatitis_C)
            }
            21-> {
                symptoms = getString(R.string.Hepatitis_D)
            }
            22-> {
                symptoms = getString(R.string.Hepatitis_E)
            }
            23-> {
                symptoms = getString(R.string.Hpertensi)
            }
            24-> {
                symptoms = getString(R.string.Hperthroid)
            }
            25-> {
                symptoms = getString(R.string.Hypogy)
            }
            26-> {
                symptoms = getString(R.string.hypothiroid)
            }
            27-> {
                symptoms = getString(R.string.impetigo)
            }
            28-> {
                symptoms = getString(R.string.jaundice)
            }
            29-> {
                symptoms = getString(R.string.malaria)
            }
            30-> {
                symptoms = getString(R.string.migraine)
            }
            31-> {
                symptoms = getString(R.string.osteorarthirs)
            }
            32-> {
                symptoms = getString(R.string.paralysis)
            }
            33-> {
                symptoms = getString(R.string.peptic_ulcer)
            }
            34-> {
                symptoms = getString(R.string.pneumonia)
            }
            35-> {
                symptoms = getString(R.string.psoriasis)
            }
            36-> {
                symptoms = getString(R.string.tbc)
            }
            37-> {
                symptoms = getString(R.string.typhoid)
            }
            38-> {
                symptoms = getString(R.string.urinary_tract)
            }
            39-> {
                symptoms = getString(R.string.varicose_vens)
            }
            40-> {
                symptoms = getString(R.string.hepatitis_A)
            }
            else -> {
                symptoms = getString(R.string.error)
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
        
        return symptoms
    }



}



