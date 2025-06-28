package ru.fefu.helloworld.features.activities_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.helloworld.databinding.FragmentActivityDetailsBinding

abstract class ActivityDetailsFragment: Fragment() {
    private var _binding: FragmentActivityDetailsBinding? = null
    protected val binding
        get() = _binding ?: throw IllegalStateException("FragmentActivityDetailsBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.icGoBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}