package ru.fefu.helloworld.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.fefu.helloworld.data.enums.ActivityType
import java.time.LocalDateTime

@Entity(tableName = "user_activities")
data class UserActivity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: ActivityType,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val distance: Int
)