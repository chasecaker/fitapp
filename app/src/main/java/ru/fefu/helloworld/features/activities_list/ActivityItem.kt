package ru.fefu.helloworld.features.activities_list

sealed class ActivityItem {
    data class DateHeader(val date: String): ActivityItem()
    data class ActivityEntry(
        val distance: String,
        val timeDuration: String,
        val activityName: String,
        val timeOver: String,
        val user: String = "",
    ): ActivityItem()
}