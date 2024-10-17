package com.example.per8_tugas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.per8_tugas.databinding.FragmentLoginBinding
import com.example.per8_tugas.databinding.FragmentRegisterBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null  // Ganti RegisterFragment dengan FragmentRegisterBinding
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inisialisasi binding untuk Fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logic di sini, misalnya setup klik listener
        with(binding) {
            btnLogin.setOnClickListener{
                val intendToSecondActivity = Intent(activity, SecondActivity::class.java)
                intendToSecondActivity.putExtra(EXTRA_USERNAME,usernameLogin.text.toString())
                intendToSecondActivity.putExtra(EXTRA_PASSWORD,passwordLogin.text.toString())
                startActivity(intendToSecondActivity)
            }
            txtRegister.setOnClickListener{
                (activity as MainActivity).findViewById<ViewPager2>(R.id.view_pager).currentItem = 0
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Set binding ke null untuk menghindari memory leaks
        _binding = null
    }
}