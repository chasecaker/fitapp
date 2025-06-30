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

                1,

                "Серфинг",
                "14.32 км",
                "14 часов назад",
                "11:00",
                "13:46",
                "2 часа 46 минут",
                "@chasecaker"

            ),
            ActivityItem.ActivityEntry(

                2,


                "Ходьба",
                "228 м",
                "14 часов назад",
                "9:00",
                "19:20",
                "10 часов 20 минут",
                "@haski"
            ),
            ActivityItem.ActivityEntry(

                3,

                "Бег по набережной",
                "10 км",
                "15 часов назад",
                "15:20",
                "18:22",
                "3 часа 2 минуты",
                "@elon_mask"
            )
        )

        super.adapter = ActivityAdapter(false, data) { activityId ->
            super.onActivityClick(activityId)
        }

        super.binding.rvActivitiesList.layoutManager = LinearLayoutManager(requireContext())
        super.binding.rvActivitiesList.adapter = super.adapter
    }
}