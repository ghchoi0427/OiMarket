package com.choi.oimarket.ui.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.choi.oimarket.databinding.FragmentLocalBinding

class LocalFragment : Fragment() {

    private lateinit var localViewModel: LocalViewModel
    private var _binding: FragmentLocalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        localViewModel =
            ViewModelProvider(this).get(LocalViewModel::class.java)

        _binding = FragmentLocalBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}