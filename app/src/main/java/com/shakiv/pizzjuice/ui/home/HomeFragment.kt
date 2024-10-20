package com.shakiv.pizzjuice.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shakiv.pizzjuice.R
import com.shakiv.pizzjuice.data.LoadState
import com.shakiv.pizzjuice.databinding.FragmentHomeBinding
import com.shakiv.pizzjuice.ui.adapter.BusinessAdapter
import com.shakiv.pizzjuice.utils.openLink
import com.shakiv.pizzjuice.utils.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var businessAdapter: BusinessAdapter

    private lateinit var binding: FragmentHomeBinding
    private val viewmodel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindListener()
        bindViews()
        bindObserver()

    }

    private fun bindObserver() {
        lifecycleScope.launch {
            viewmodel.businesses.collectLatest {
                when (it) {
                    is LoadState.Loading -> {
                        binding.progressCircular.isVisible = true
                        binding.tvError.isVisible = false
                    }

                    is LoadState.Success -> {
                        binding.tvError.isVisible = false
                        binding.progressCircular.isVisible = false
                        businessAdapter.submitList(it.businessResponse?.businesses.orEmpty())
                    }

                    is LoadState.Error -> {
                        binding.progressCircular.isVisible = false
                        binding.tvError.isVisible = true
                        binding.tvError.text = it.message
                    }
                }
            }
        }
    }

    private fun bindViews() {
        binding.recyclerView.adapter = businessAdapter
        binding.recyclerView.setHasFixedSize(true)
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    private fun bindListener() {

        binding.searchOptions.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {

                R.id.rbPizza -> {
                    viewmodel.selectedTerm = getString(R.string.pizza)
                    searchText(viewmodel.searchText)
                }

                R.id.rbJuice -> {
                    viewmodel.selectedTerm = getString(R.string.juice)
                    searchText(viewmodel.searchText)
                }
            }
        }

        binding.etSearch.textChanges()
            .debounce(300)
            .onEach {
                searchText(it.toString())
            }
            .launchIn(lifecycleScope)

    }

    private fun searchText(string: String) {
        viewmodel.searchText = string
        lifecycleScope.launch {
            viewmodel.searchBusiness(viewmodel.searchText, viewmodel.selectedTerm)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchText(viewmodel.searchText)
        businessAdapter = BusinessAdapter {
            openLink(it?.url.orEmpty())
        }

    }


}