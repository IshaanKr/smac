package com.icg.smac.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.icg.smac.R
import com.icg.smac.fragments.ViewTicketFragment

class ViewTicketAdapter(val fragment: ViewTicketFragment) :
    RecyclerView.Adapter<ViewTicketAdapter.ViewTicketViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewTicketViewHolder {
        return ViewTicketViewHolder(
            LayoutInflater.from(fragment.requireContext())
                .inflate(R.layout.view_ticket_list_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewTicketViewHolder, position: Int) {
        holder.viewTicketItem.setOnClickListener {
            fragment.findNavController()
                .navigate(R.id.action_viewTicketFragment_to_viewSingleTicketFragment)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewTicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val viewTicketItem: CardView = itemView.findViewById(R.id.view_ticket_item_root)
    }

}


