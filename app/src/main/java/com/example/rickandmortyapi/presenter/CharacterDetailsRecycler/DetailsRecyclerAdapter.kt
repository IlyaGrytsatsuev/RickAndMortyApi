package com.example.rickandmortyapi.presenter.CharacterDetailsRecycler

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.domain.models.RecyclerModel
import com.example.rickandmortyapi.presenter.commonRecyclerUtils.RecyclerItemDelegate

class DetailsRecyclerAdapter (private val delegates: List<RecyclerItemDelegate>, )
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var detailsModel:RecyclerModel? = null

    fun setCharacterDetailsModel(value:RecyclerModel){
        detailsModel = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerView.ViewHolder =
        delegates[viewType].getViewHolder(parent)


    override fun getItemCount(): Int {
        val count  = detailsModel?.let {
            delegates.size +
                    it.listSize - 1 } ?: 0

        Log.d("netlist", "items count = $count ")
        return count
    }

    override fun getItemViewType(position: Int) : Int {
        if (position < delegates.size - 1)
            return position

        return delegates.size - 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val curListPosition = position - delegates.size + 1
        detailsModel?.let {
            if (position < delegates.size - 1)
                delegates[getItemViewType(position)]
                    .bindViewHolder(holder, it)
            else
                delegates[delegates.size - 1]
                    .bindViewHolder(holder, it, curListPosition)

        }
    }


}