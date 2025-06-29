package ru.fefu.helloworld.features.activity_new

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.helloworld.databinding.ItemActivityTypeBinding

class BottomSheetAdapter(
private val items: List<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class BottomSheetViewHolder(private val binding: ItemActivityTypeBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(activityTypeName: String) {
            binding.tvActivityType.text = activityTypeName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityTypeBinding.inflate(inflater, parent, false)

        return BottomSheetViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BottomSheetViewHolder).bind(items[position])
    }
}