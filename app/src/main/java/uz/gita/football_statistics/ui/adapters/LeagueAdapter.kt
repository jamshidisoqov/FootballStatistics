package uz.gita.football_statistics.ui.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.football_statistics.R
import uz.gita.football_statistics.data.models.LeagueData
import uz.gita.football_statistics.databinding.ListItemLeagueBinding
import uz.gita.football_statistics.utils.extesions.inflate

// Created by Jamshid Isoqov an 8/29/2022
class LeagueAdapter : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {


    private var leagueList: List<LeagueData> = emptyList()
    private var itemClickListener: ((LeagueData) -> Unit)? = null


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<LeagueData>) {
        leagueList = list
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ListItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.invoke(leagueList[absoluteAdapterPosition])
            }
        }

        fun onBind() {
            val date = leagueList[absoluteAdapterPosition]

            binding.apply {
                Glide.with(imageLeague.context)
                    .load(date.logos.light)
                    .placeholder(R.drawable.premier)
                    .centerCrop()
                    .into(imageLeague)
                tvLeague.text = date.name
                tvLeague.setSingleLine()
                tvLeague.isSelected = true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListItemLeagueBinding.bind(parent.inflate(R.layout.list_item_league))
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    override fun getItemCount(): Int = leagueList.size

    fun setItemClickListener(block: (LeagueData) -> Unit) {
        itemClickListener = block
    }

}