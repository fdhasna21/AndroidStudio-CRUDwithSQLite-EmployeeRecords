package com.example.latihancrud

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(val arrayList: ArrayList<EmpModel>, val context : Context)
    : RecyclerView.Adapter<EmpAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val layoutAdapt = itemView.findViewById<View>(R.id.recordlayout_container)
        val nameAdapt = itemView.findViewById<TextView>(R.id.recordlayout_name)
        val moreAdapt = itemView.findViewById<ImageView>(R.id.recordlayout_more)
        val editAdapt = itemView.findViewById<ImageView>(R.id.recordlayout_edit)
        val removeAdapt = itemView.findViewById<ImageView>(R.id.recordlayout_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.record_layout, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayList.get(position)
        holder.nameAdapt.text = item.name
        if(position%2==0) {
            holder.layoutAdapt.setBackgroundColor(ContextCompat.getColor(context,R.color.cream2_regular))
        }

        holder.editAdapt.setOnClickListener{
            if(context is MainActivity){context.editRecord(item)}
        }

        holder.removeAdapt.setOnClickListener{
            if(context is MainActivity){context.deleteRecord(item)}
        }

        holder.moreAdapt.setOnClickListener{
            if(context is MainActivity){context.moreRecord(item) }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}