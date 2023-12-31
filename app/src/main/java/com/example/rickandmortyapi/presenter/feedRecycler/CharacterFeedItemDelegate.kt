package com.example.rickandmortyapi.presenter.feedRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.FeedRecyclerCharacterItemBinding
import com.example.rickandmortyapi.domain.models.CharacterModel
import com.example.rickandmortyapi.domain.models.RecyclerModel
import com.example.rickandmortyapi.presenter.commonRecyclerUtils.RecyclerItemDelegate

class CharacterFeedItemDelegate(private val itemChoiceFun
:((characterId:Int)->Unit)? = null) : RecyclerItemDelegate {
    override fun isOfViewType(characterItem: RecyclerModel): Boolean {
        return characterItem is CharacterModel
    }

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CharacterFeedRecyclerViewHolder(
            FeedRecyclerCharacterItemBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false))

    }

    override fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, characterItem: RecyclerModel,
                                position: Int?) {
        (viewHolder as CharacterFeedRecyclerViewHolder).let {
            viewHolder.onBind(characterItem as CharacterModel, itemChoiceFun) }
    }
}