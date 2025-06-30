package ru.fefu.helloworld.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.fefu.helloworld.data.dao.ActivityDao
import ru.fefu.helloworld.data.model.UserActivity

@Database(entities = [UserActivity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}