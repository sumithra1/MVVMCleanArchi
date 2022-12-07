package com.example.mvvmcleanarchidemo1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchidemo1.R
import com.example.mvvmcleanarchidemo1.data.util.Resource
import com.example.mvvmcleanarchidemo1.databinding.ActivityMainBinding
import com.example.mvvmcleanarchidemo1.presentation.adapters.GamesAdapter
import com.example.mvvmcleanarchidemo1.presentation.viewmodels.GamesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    var myAdapter:GamesAdapter?=null
    private val viewmodel: GamesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        attachObserver()
        initView()


    }
    private fun setupRecyclerView(){
        recyclerView=findViewById(R.id.recycler)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            myAdapter= GamesAdapter(this@MainActivity, arrayListOf())
            adapter=myAdapter
        }
    }
    private fun attachObserver(){
        viewmodel.getGamesData()
        viewmodel.gamesdetails.observe(this, Observer {
            it.data
                ?.amiibo?.let { it1 -> myAdapter?.setData(it1) }
        })
    }
    private fun initView(){
        setupRecyclerView()
    }
}