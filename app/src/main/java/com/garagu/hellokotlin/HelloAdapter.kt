package com.garagu.hellokotlin

/**
 * Created by garagu.
 */
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_hello.view.*

class HelloAdapter(val items: List<HelloModel>, val listener: OnItemClickListener) : RecyclerView.Adapter<HelloAdapter.HelloViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelloViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_hello, parent, false)
        return HelloViewHolder(view)
    }

    override fun onBindViewHolder(holder: HelloViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener { listener.onClick(item) }
        holder.bind(item)
    }

    class HelloViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(model: HelloModel) = with(itemView) {
            txtName.text = model.name
            txtAge.text = model.age.toString()
            txtAddress.text = model.address
        }

    }

    interface OnItemClickListener {
        fun onClick(item: HelloModel)
    }

}