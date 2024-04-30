package com.agvber.kakao_api.presentation.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvber.kakao_api.databinding.FragmentBookmarkBinding
import com.agvber.kakao_api.presentation.search.SearchRecyclerViewAdapter
import com.agvber.kakao_api.presentation.search.SearchViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BookmarkFragment : Fragment() {
    private val viewModel: SearchViewModel by activityViewModels { SearchViewModel.viewModelFactory }

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SearchRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        collectRecyclerViewItem()
        lifecycleScope.launch {
            viewModel.itemCheckedSet.collectLatest {
                adapter.updateItemCheckedSet(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        adapter = SearchRecyclerViewAdapter { imageUrl, isChecked ->
            viewModel.updateItemCheckSet {
                val mutableSet = it.toMutableSet()
                if (isChecked) {
                    mutableSet.add(imageUrl)
                } else {
                    mutableSet.remove(imageUrl)
                }

                mutableSet
            }
        }
        val recyclerviewLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.bookmarkRecyclerView.adapter = adapter
        binding.bookmarkRecyclerView.layoutManager = recyclerviewLayoutManager
    }

    private fun collectRecyclerViewItem() = lifecycleScope.launch {
        viewModel.images.collect {
            adapter.submitData(this@BookmarkFragment.lifecycle, it)
        }
    }

}