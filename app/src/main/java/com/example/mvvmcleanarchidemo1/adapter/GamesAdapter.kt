package com.example.mvvmcleanarchidemo1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Amiibo

import com.example.mvvmcleanarchidemo1.databinding.GamesListItemBinding
import javax.inject.Inject

class GamesAdapter @Inject constructor(
    val context: Context,
    private val gamesItem: ArrayList<Amiibo>
) : RecyclerView.Adapter<GamesAdapter.MyViewHolder>() {

    fun setData(newData: List<Amiibo>) {
        gamesItem.clear()
        gamesItem.addAll(newData)
        notifyDataSetChanged()
    }

    class MyViewHolder(private val binding: GamesListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(games: Amiibo) {
            binding.series.text = games.amiiboSeries
            binding.name.text = games.name
            Glide.with(binding.imageView.context)
                .load(games.image).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            GamesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val postBind = gamesItem[position]
        holder.bind(postBind)
    }

    override fun getItemCount(): Int {
        return gamesItem.size
    }

}