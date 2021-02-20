package com.kamil.fivedaysforecast

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kamil.fivedaysforecast.data.network.ApiService
import com.kamil.fivedaysforecast.data.network.response.ForecastResponse
import com.kamil.fivedaysforecast.ui.RecyclerViewAdapter
import com.kamil.fivedaysforecast.ui.viewmodel.CurrentWeatherViewModel
import com.kamil.fivedaysforecast.ui.viewmodel.CurrentWeatherViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var apiService: ApiService
    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = ApiService()
        viewModel = CurrentWeatherViewModelFactory().create(CurrentWeatherViewModel::class.java)
        viewModel.recyclerListData.observe(this, Observer<ForecastResponse>{
            if(it != null) {
                recyclerViewAdapter.setListData(it.timePeriods)
                recyclerViewAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@MainActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })

        val etCity: EditText = findViewById(R.id.etCity)
        val btnSearch: Button = findViewById(R.id.btnSearch)

        btnSearch.setOnClickListener {
            viewModel.makeApiCall(etCity.text.toString())
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.rvForecasts)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration =
                DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }
}