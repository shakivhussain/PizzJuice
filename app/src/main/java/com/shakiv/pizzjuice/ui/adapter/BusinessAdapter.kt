package com.shakiv.pizzjuice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shakiv.pizzjuice.R
import com.shakiv.pizzjuice.data.model.Businesse
import com.shakiv.pizzjuice.databinding.ItemBusinessBinding
import com.shakiv.pizzjuice.utils.ImageUtils.setProfileImage

class BusinessAdapter(
    private val onItemClicked: (Businesse?) -> Unit
) : ListAdapter<Businesse, BusinessAdapter.BusinessViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {

        val binding =
            ItemBusinessBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessViewHolder(binding, onItemClicked)

    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {

        holder.bind(position)
    }

    inner class BusinessViewHolder(
        private val binding: ItemBusinessBinding,
        onItemClicked: (Businesse?) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private var _business: Businesse? = null

        init {

            binding.viewBusiness.setOnClickListener {
                onItemClicked.invoke(_business)
            }

        }

        fun bind(position: Int) {

            val business = getItem(position)
            _business = business

            binding.tvBusinessName.text =
                business.name ?: binding.root.context.getString(R.string.unknkown)
            binding.tvBusinessAddress.text = business.location?.getFormattedDisplayAddress()
            binding.businessRating.rating = business.rating ?: 0f
            binding.ratingCount.text = business.review_count.toString()
            binding.tvPhoneNumber.text =
                "Phone : ${business.display_phone?.takeIf { it.isNotBlank() } ?: "Unknown"}"
            setProfileImage(business.image_url, binding.businessImage)
        }

    }

    object COMPARATOR : DiffUtil.ItemCallback<Businesse>() {
        override fun areItemsTheSame(oldItem: Businesse, newItem: Businesse): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Businesse, newItem: Businesse): Boolean {
            return false
        }
    }
}