package com.example.rickandmortyapi.presenter.feedRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.FeedRecyclerStandartItemBinding

class StandartRecyclerFeedItemDelegate(private val context: Context) : FeedItemDelegate {
    override fun isOfViewType(memeItem: MemeModel): Boolean {
        //todo()
        return true
    }

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return FeedRecyclerViewHolder(
            FeedRecyclerStandartItemBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false))

    }

    override fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, memeItem: MemeModel) {
        (viewHolder as FeedRecyclerViewHolder).let { viewHolder.onBind(memeItem, context) }
    }
}