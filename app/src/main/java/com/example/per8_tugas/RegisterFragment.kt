package com.example.per8_tugas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.per8_tugas.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null  // Ganti RegisterFragment dengan FragmentRegisterBinding
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inisialisasi binding untuk Fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logic di sini, misalnya setup klik listener
        with(binding) {
            btnReg.setOnClickListener{
                val intentToSecondActivity = Intent(activity,SecondActivity::class.java)
                intentToSecondActivity.putExtra(EXTRA_USERNAME,usernameReg.text.toString())
                intentToSecondActivity.putExtra(EXTRA_EMAIL,emailReg.text.toString())
                intentToSecondActivity.putExtra(EXTRA_PHONE,phoneReg.text.toString())
                intentToSecondActivity.putExtra(EXTRA_PASSWORD,passwordReg.text.toString())
                startActivity(intentToSecondActivity)
            }
            txtLogin.setOnClickListener{
                (activity as MainActivity).findViewById<ViewPager2>(R.id.view_pager).currentItem = 1
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Set binding ke null untuk menghindari memory leaks
        _binding = null
    }
}
