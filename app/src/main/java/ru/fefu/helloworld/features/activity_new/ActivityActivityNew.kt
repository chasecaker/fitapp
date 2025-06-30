package ru.fefu.helloworld.features.activity_new

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.helloworld.data.db.DatabaseProvider
import ru.fefu.helloworld.data.enums.ActivityType
import ru.fefu.helloworld.data.model.UserActivity
import ru.fefu.helloworld.data.repository.ActivityRepository
import ru.fefu.helloworld.databinding.ActivityActivityNewBinding
import ru.fefu.helloworld.ui.ActivityViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.time.LocalDateTime

class ActivityActivityNew: AppCompatActivity() {
    private var _binding: ActivityActivityNewBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("ActivityActivityNewBinding is null")

    private lateinit var _bottomSheetAdapter: BottomSheetAdapter

    private val _activityViewModel: ActivityViewModel by viewModels {
        val activityDao = DatabaseProvider.getDatabase(applicationContext).activityDao()
        val repository = ActivityRepository(activityDao)

        viewModelFactory {
            initializer {
                ActivityViewModel(repository)
            }
        }
    }


    private fun initActivityTypesList() {
        val bottomSheetAdapter = BottomSheetAdapter(listOf(
            ActivityType.BICYCLE,
            ActivityType.RUN,
            ActivityType.WALK
        ))
        _bottomSheetAdapter = bottomSheetAdapter

        with(binding.recyclerView) {
            adapter = bottomSheetAdapter
            layoutManager = LinearLayoutManager(
                this@ActivityActivityNew,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(HorizontalSpaceItemDecoration(this@ActivityActivityNew, 16))
        }
    }

    private fun setBottomSheetHeight() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.llBottomSheet)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun initBottomSheet() {
        setBottomSheetHeight()

        initActivityTypesList()
    }

    private fun setStartButtonOnClickListener() {
        with(binding) {
            btnStart.setOnClickListener {
                flStart.visibility = View.GONE
                flFinish.visibility = View.VISIBLE

                tvActivityName.text = _bottomSheetAdapter.getActivityType().typeName

                llBottomSheet.post {
                    setBottomSheetHeight()
                }
            }
        }
    }

    private fun setFinishButtonOnClickListener() {
        with(binding) {
            btnFinish.setOnClickListener {
                flStart.visibility = View.VISIBLE
                flFinish.visibility = View.GONE

                _activityViewModel.addActivity(UserActivity(
                    type = _bottomSheetAdapter.getActivityType(),
                    startTime = LocalDateTime.now().minusHours(3),
                    endTime = LocalDateTime.now(),
                    distance = 777
                ))

                llBottomSheet.post {
                    setBottomSheetHeight()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomSheet()

        setStartButtonOnClickListener()
        setFinishButtonOnClickListener()
    }
}