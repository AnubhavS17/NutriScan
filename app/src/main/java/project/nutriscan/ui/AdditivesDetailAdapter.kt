package project.nutriscan.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import project.nutriscan.databinding.ItemAdditiveDetailBinding
import project.nutriscan.model.AdditiveInfo

class AdditivesDetailAdapter : ListAdapter<AdditiveInfo, AdditivesDetailAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemAdditiveDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AdditiveInfo) {
            binding.additiveCode.text = item.code
            binding.additiveName.text = item.fullName
            binding.additiveCategory.text = item.category
            binding.additiveSafety.text = item.safetyInfo
            binding.additiveHealthConcerns.text = item.healthConcerns

            // Optional: Color code for safety info
            val safetyColor = when {
                item.safetyInfo.contains("caution", ignoreCase = true) ->
                    ContextCompat.getColor(binding.root.context, android.R.color.holo_orange_dark)
                item.safetyInfo.contains("avoid", ignoreCase = true) ->
                    ContextCompat.getColor(binding.root.context, android.R.color.holo_red_dark)
                else -> ContextCompat.getColor(binding.root.context, android.R.color.holo_green_dark)
            }
            binding.additiveSafety.setTextColor(safetyColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdditiveDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<AdditiveInfo>() {
        override fun areItemsTheSame(oldItem: AdditiveInfo, newItem: AdditiveInfo): Boolean =
            oldItem.code == newItem.code

        override fun areContentsTheSame(oldItem: AdditiveInfo, newItem: AdditiveInfo): Boolean =
            oldItem == newItem
    }
}
