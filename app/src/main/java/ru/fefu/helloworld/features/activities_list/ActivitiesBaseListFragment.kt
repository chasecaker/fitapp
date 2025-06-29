package ru.fefu.helloworld.features.activities_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.helloworld.R
import ru.fefu.helloworld.databinding.FragmentActivitiesListBinding

abstract class ActivitiesBaseListFragment: Fragment() {
    private var _binding: FragmentActivitiesListBinding? = null
    protected val binding
        get() = _binding ?: throw IllegalStateException("FragmentActivitiesListBinding is null")
    protected lateinit var adapter: ActivityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentActivitiesListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ActivityAdapter(true, listOf()) {
            onActivityClick()
        }

        binding.rvActivitiesList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvActivitiesList.adapter = adapter
    }

    protected fun onActivityClick() {
        binding.rvActivitiesList.visibility = View.GONE

        val activityDetailsFragment = if (adapter.isMy) ActivityMyDetailsFragment() else ActivityUsersDetailsFragment()

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, activityDetailsFragment)
            .addToBackStack("activityDescription")
            .commit()
    }
}