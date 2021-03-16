/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.ui.gnome_list.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.oswaldokavak.R
import com.app.oswaldokavak.data.model.Brastlewark
import com.app.oswaldokavak.utils.extensions_functions.loadurl
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.card.MaterialCardView
import com.makeramen.roundedimageview.RoundedImageView


class GnomeListAdapter : RecyclerView.Adapter<GnomeListAdapter.ViewHolder>() {

    private var brastlewarks: ArrayList<Brastlewark> = ArrayList()
    private lateinit var context: Context
    private lateinit var iGnomeListEvent: IGnomeListEvent

    fun recyclerAdapter( itemes: List<Brastlewark>, context: Context, iGnomeListEvent: IGnomeListEvent ) {
        this.brastlewarks = ArrayList(itemes)
        this.context = context
        this.iGnomeListEvent = iGnomeListEvent
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = brastlewarks[position]
        holder.bind(item, context, iGnomeListEvent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_brastlewark_list, parent, false))
    }

    override fun getItemCount(): Int {
        return brastlewarks.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val card = view.findViewById(R.id.card) as MaterialCardView
        private val rivProfile = view.findViewById(R.id.rivProfile) as RoundedImageView
        private val tvName = view.findViewById(R.id.tvName) as TextView

        @SuppressLint("CheckResult")
        fun bind(item: Brastlewark, context: Context, iGnomeListEvent: IGnomeListEvent) {
            tvName.text = item.name
            rivProfile.loadurl(item.thumbnail)
            card.setOnClickListener {
                iGnomeListEvent.onGnomeClick(item)
            }
        }
    }
}