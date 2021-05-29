package com.newshelter.langkah.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.LandingActivity
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentProfileBinding
import com.newshelter.langkah.utils.DataDummy


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var viewModel : ProfileViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dummyUsers = DataDummy.generateDummyUser()
        val fireUser = auth.currentUser

        val user = dummyUsers[2]

        val fm = childFragmentManager
        val mNoStatusFragment = NoStatusFragment()

        val mOnProcessStatusFragment = OnProcessStatusFragment()

        val mMadeStatusFragment = MadeStatusFragment()
        val bundle = Bundle()

        mMadeStatusFragment.arguments = bundle

        bundle.putString(MadeStatusFragment.EXTRA_USER_ID, user.userId)

        val parentFm = parentFragmentManager

//        val mEditProfileFragment = EditProfileFragment()
//
//        val editBundle = Bundle()
//
//        editBundle.putString(EditProfileFragment.EXTRA_USER_ID, user.userId)
//        mEditProfileFragment.arguments = editBundle

               with(binding){
// ard            tvUserName.text = user.userFullName
 //ard           tvUserEmail.text = user.userEmail
    //ard        tvUserPhone.text = user.phoneNumber

//            Status = 3 = Belum Buat Janji
//            Status = 2 = Janji lagi di proses sama admin
//            Status = 1 = Janji dibuat
                 
                 // Bagian atas punya ardi


                   tvUserName.text = fireUser?.displayName
                   tvUserEmail.text = fireUser?.email
                   tvUserPhone.text = fireUser?.phoneNumber


                   Glide.with(this@ProfileFragment)
                       .load(fireUser?.photoUrl)
                       .apply(RequestOptions.placeholderOf(R.drawable.blue_account_circle_24)
                           .error(R.drawable.empty))
                       .into(accountCircle)

            btnSignOut.setOnClickListener {
                val i = Intent(context, LandingActivity::class.java)
                startActivity(i)
            }

            btnEdit.setOnClickListener {
                val i = Intent(context, EditProfileActivity::class.java)
                i.putExtra(EditProfileActivity.EXTRA_USER_ID, user.userId)
                startActivity(i)
            }

            btnChangePassword.setOnClickListener {
                val i = Intent(context, ChangePasswordActivity::class.java)
                i.putExtra(ChangePasswordActivity.EXTRA_USER_ID, user.userId)
                startActivity(i)
            }

            if (user.appointmentStatus == "3"){
                tvNoStatus.text = context?.getString(R.string.no_appointment)
                fm.beginTransaction()
                    .add(R.id.frame_appointment_container, mNoStatusFragment, NoStatusFragment::class.java.simpleName)
                    .commit()

            } else if (user.appointmentStatus == "2"){
                tvNoStatus.visibility = View.INVISIBLE
                tvProcessStatus.visibility = View.VISIBLE
                tvProcessStatus.text = context?.getString(R.string.appointment_on_process)

                fm.beginTransaction()
                    .add(R.id.frame_appointment_container, mOnProcessStatusFragment, OnProcessStatusFragment::class.java.simpleName)
                    .commit()

            } else {
                tvNoStatus.visibility = View.INVISIBLE
                tvMadeStatus.visibility = View.VISIBLE
                tvMadeStatus.text = context?.getString(R.string.appointment_made)

                fm.beginTransaction()
                    .add(R.id.frame_appointment_container, mMadeStatusFragment, MadeStatusFragment::class.java.simpleName)
                    .commit()
            }

        }
    }


}