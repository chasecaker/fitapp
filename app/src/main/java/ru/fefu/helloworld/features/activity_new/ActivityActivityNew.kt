package ru.fefu.helloworld.features.activity_new

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.helloworld.databinding.ActivityActivityNewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ActivityActivityNew: AppCompatActivity() {
    private var _binding: ActivityActivityNewBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("ActivityActivityNewBinding is null")


    private fun initActivityTypesList() {
        val bottomSheetAdapter = BottomSheetAdapter(listOf(
            "Велосипед",
            "Бег",
            "Шаг"
        ))

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