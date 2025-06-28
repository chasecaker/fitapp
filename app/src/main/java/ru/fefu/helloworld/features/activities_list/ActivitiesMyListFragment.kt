package ru.fefu.helloworld.features.activities_list
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

class ActivitiesMyListFragment: ActivitiesBaseListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            ActivityItem.DateHeader("Вчера"),
            ActivityItem.ActivityEntry(
                "14.32 км",
                "2 часа 46 минут",
                "Серфинг \uD83C\uDFC4",
                "14 часов назад"
            ),
            ActivityItem.DateHeader("Май 2022 года"),
            ActivityItem.ActivityEntry(
                "1000 м",
                "60 минут",
                "Велосипед \uD83D\uDEB2",
                "29.05.2022"
            )
        )

        super.adapter = ActivityAdapter(true, data) {
            super.onActivityClick()
        }

        super.binding.rvActivitiesList.layoutManager = LinearLayoutManager(requireContext())
        super.binding.rvActivitiesList.adapter = super.adapter
    }
}