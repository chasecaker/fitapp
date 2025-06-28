package ru.fefu.helloworld.features.activities_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.helloworld.R
import ru.fefu.helloworld.ui.TabPagerAdapter
import ru.fefu.helloworld.databinding.FragmentActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class ActivityFragment: Fragment() {
    private var _binding: FragmentActivityBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("FragmentActivityBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)

        with(binding) {
            viewPager.adapter = TabPagerAdapter(this@ActivityFragment)

            TabLayoutMediator(tabLayout, viewPager) {tab, position ->
                when (position) {
                    0 -> tab.setText(getText(R.string.tab_my))
                    1 -> tab.setText(getText(R.string.tab_users))
                }
            }.attach()

            return root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}