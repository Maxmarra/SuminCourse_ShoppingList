package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter :
    RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_disabled,
            parent,
            false
        )

        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        val status = if (shopItem.enabled) {
            "Active"
        } else {
            "Inactive"
        }


        holder.itemView.setOnLongClickListener {
            true
        }


        if (shopItem.enabled) {
            holder.tvName.text = "${shopItem.name} $status"
            holder.tvCount.text = shopItem.count.toString()
            holder.tvName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    android.R.color.holo_blue_light
                )
            )
        } else {
            holder.tvName.text = ""
            holder.tvCount.text = ""
            holder.tvName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    android.R.color.white
                )
            )
        }
    }

    override fun getItemCount() = shopList.size

//    override fun getItemViewType(position: Int): Int {
//        return position
//    }
//
//    override fun onViewRecycled(holder: ShopItemViewHolder) {
//        super.onViewRecycled(holder)
//    }

}

