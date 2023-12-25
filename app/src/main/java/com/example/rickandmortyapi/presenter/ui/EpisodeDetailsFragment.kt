package com.example.rickandmortyapi.presenter.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.di.daggerComponents.CharacterDetailsFragmentComponent
import com.example.rickandmortyapi.di.daggerComponents.EpisodeDetailsFragmentComponent
import com.example.rickandmortyapi.domain.models.RecyclerModel
import com.example.rickandmortyapi.presenter.CharacterDetailsRecycler.DetailsRecyclerAdapter
import com.example.rickandmortyapi.presenter.State
import com.example.rickandmortyapi.presenter.commonRecyclerUtils.RecyclerItemDelegate
import com.example.rickandmortyapi.presenter.viewmodels.EpisodeDetailsViewModel
import com.example.rickandmortyapi.presenter.viewmodels.InternetConnectionObserverViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeDetailsFragment() : AbstractDetailsFragment() {

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory
    override val internetObserverViewModel: InternetConnectionObserverViewModel
    by viewModels {viewModelFactory}

    private val viewModel: EpisodeDetailsViewModel
    by viewModels {viewModelFactory}
    override val delegates: List<RecyclerItemDelegate> by lazy {
        listOf()
        //TODO delegates
    }

    override val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder> by lazy {
        DetailsRecyclerAdapter(delegates)
    }


//private val component: EpisodeDetailsFragmentComponent by lazy {
//    DaggerEpisodeDetailsFragmentComponent.factory().create(requireContext(),
//        arguments?.getInt(EpisodeDetailsFragment.EPISODE_ID_PARAM, 0) ?: 0 )
//} TODO

    override fun setUpDetailsStateObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.curEpisode.collect{
                    when(it){
                        is State.Error ->
                            executeErrorState(it.data)

                        is State.Empty ->
                            executeEmptyState()

                        is State.Loading ->
                            executeLoadingState()
                        is State.Success ->
                            executeSuccessState(it.data)

                    }
                }
            }
        }
    }

    override fun reloadDetails() {
        //binding.detailsRecycler.scrollToPosition(0)
        viewModel.getEpisodeDetails()
    }


    override fun executeErrorState(data: RecyclerModel?) {
        TODO("Not yet implemented")
    }

    override fun executeEmptyState() {
        TODO("Not yet implemented")
    }

    override fun executeLoadingState() {
        TODO("Not yet implemented")
    }

    override fun executeSuccessState(data: RecyclerModel?) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val EPISODE_ID_PARAM = "EPISODE_ID_PARAM"
        fun newInstance(episodeId: Int):EpisodeDetailsFragment =
            EpisodeDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(EPISODE_ID_PARAM, episodeId)
                }
            }
    }
}