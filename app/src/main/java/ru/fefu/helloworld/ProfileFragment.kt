package ru.fefu.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.helloworld.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("FragmentProfleBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }
}