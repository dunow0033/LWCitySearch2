package com.express.android.lwfirstandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.android.lwfirstandroid.databinding.ActivityRecyclerViewBinding
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.express.android.lwfirstandroid.network.RetroInstance
import com.express.android.lwfirstandroid.network.RetroService
import com.express.android.lwfirstandroid.viewmodels.RecyclerActivityViewModel
import retrofit2.Call
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun createData() {
//        val item = ArrayList<RecyclerData>()
//
//        item.add(RecyclerData("Java", "Java description"))
//        item.add(RecyclerData("C++", "C++ description"))
//        item.add(RecyclerData("PHP", "PHP description"))
//        item.add(RecyclerData("Kotlin", "Kotlin description"))
//
//        recyclerViewAdapter.setListData(item)
//        recyclerViewAdapter.notifyDataSetChanged()

        val viewModel = ViewModelProvider(this).get(RecyclerActivityViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList> {
            if(it != null){
                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
        binding.searchButton.setOnClickListener {
            viewModel.makeApiCall(binding.SearchBox.text.toString())
        }
    }
}