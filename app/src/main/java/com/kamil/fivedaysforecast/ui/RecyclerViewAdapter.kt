package com.kamil.fivedaysforecast.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamil.fivedaysforecast.R
import com.kamil.fivedaysforecast.data.network.response.TimePeriodItem
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<TimePeriodItem>()

    fun setListData(periods: ArrayList<TimePeriodItem>) {
        this.items = periods
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvTime = view.tvTime
        val tvTemp = view.tvTemp

        fun bind(timePeriod: TimePeriodItem) {
            tvTime.text = timePeriod.dtTxt
            tvTemp.text = timePeriod.main.tempMax.toString()
        }
    }
}