package ru.fefu.helloworld.data.repository

import androidx.lifecycle.LiveData
import ru.fefu.helloworld.data.dao.ActivityDao
import ru.fefu.helloworld.data.model.UserActivity

class ActivityRepository(private val dao: ActivityDao) {
    suspend fun insertActivity(userActivity: UserActivity) {
        dao.insertActivity(userActivity)
    }

    fun getAllActivities(): LiveData<List<UserActivity>> {
        return dao.getAllActivities()
    }

    fun getActivityById(activityId: Int): LiveData<UserActivity> {
        return dao.getActivityById(activityId)
    }

    suspend fun deleteActivityById(activityId: Int) {
        dao.deleteActivityById(activityId)
    }
}