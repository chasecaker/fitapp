package ru.fefu.helloworld.features.activities_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

class ActivitiesUsersListFragment: ActivitiesBaseListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            ActivityItem.DateHeader("Вчера"),
            ActivityItem.ActivityEntry(
                "14.32 км",
                "2 часа 46 минут",
                "Серфинг",
                "14 часов назад",
                user = "@chasecaker"

            ),
            ActivityItem.ActivityEntry(
                "228 м",
                "14 часов 48 минут",
                "Йога",
                "14 часов назад",
                user = "@haski"
            ),
            ActivityItem.ActivityEntry(
                "10 км",
                "1 час 10 минут",
                "Бег по набережной",
                "14 часов назад",
                user = "@elon_mask"
            )
        )

        super.adapter = ActivityAdapter(false, data) {
            super.onActivityClick()
        }

        super.binding.rvActivitiesList.layoutManager = LinearLayoutManager(requireContext())
        super.binding.rvActivitiesList.adapter = super.adapter
    }
}