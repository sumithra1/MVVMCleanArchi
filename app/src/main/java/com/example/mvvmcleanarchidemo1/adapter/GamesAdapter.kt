package com.example.gamessupermariofinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.domain.entity.Amiibo

import com.example.mvvmcleanarchidemo1.databinding.GamesListItemBinding
import javax.inject.Inject

class GamesAdapter @Inject constructor( val context: Context,private val gamesItem:ArrayList<Amiibo>):RecyclerView.Adapter<GamesAdapter.MyviewHolder>() {

    fun setData(newData:List<Amiibo>){
        gamesItem.clear()
        gamesItem.addAll(newData)
        notifyDataSetChanged()
    }
    class MyviewHolder(val binding: GamesListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(games: Amiibo){
            binding.series.text=games.amiiboSeries
            binding.name.text=games.name
            Glide.with(binding.imageView.context)
                .load(games.image).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val binding= GamesListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val postbind=gamesItem[position]
        holder.bind(postbind)
    }

    override fun getItemCount():Int {
        return  gamesItem.size
    }

}