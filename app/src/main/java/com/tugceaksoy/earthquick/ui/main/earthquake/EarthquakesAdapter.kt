package com.tugceaksoy.earthquick.ui.main.earthquake

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugceaksoy.earthquick.data.model.EarthquakeModelItem
import com.tugceaksoy.earthquick.databinding.RecItemBinding

class EarthquakesAdapter(private var earthQuakeList: ArrayList<EarthquakeModelItem>) :
    RecyclerView.Adapter<EarthquakesAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: RecItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var earthQuake = earthQuakeList[position]
        holder.binding.buyukluk.text = earthQuake.buyukluk
        holder.binding.gun.text = "Tarih :" + " " +earthQuake.tarih
        holder.binding.derinlik.text = "Derinlik :" + " " + earthQuake.derinlik
        holder.binding.saat.text = "Saat :" + " " + earthQuake.saat
        holder.binding.sehir.text = earthQuake.sehir
        holder.binding.konum.text = earthQuake.yer
    }

    override fun getItemCount(): Int {
        return earthQuakeList.size
    }

    fun setEarthQuakeList(_list: ArrayList<EarthquakeModelItem>) {
        earthQuakeList = _list
        notifyDataSetChanged()
    }
}