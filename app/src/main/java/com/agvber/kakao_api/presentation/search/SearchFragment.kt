package com.agvber.kakao_api.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvber.kakao_api.databinding.FragmentSearchBinding
import com.agvber.kakao_api.model.Images
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by activityViewModels { SearchViewModel.viewModelFactory }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SearchRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        lifecycleScope.collectRecyclerViewItem()
        lifecycleScope.collectItemCheckList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        adapter = SearchRecyclerViewAdapter(this::searchRecyclerViewCheckChangeListener)
        val recyclerviewLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.searchRecyclerView.adapter = adapter
        binding.searchRecyclerView.layoutManager = recyclerviewLayoutManager
    }

    private fun searchRecyclerViewCheckChangeListener(item: Images.Item, isChecked: Boolean) {
        viewModel.updateItemChecked {
            it.apply {
                if (isChecked) {
                    it.add(item.imageUrl.image)
                    return@apply
                }
                it.remove(item.imageUrl.image)
            }
        }
    }

    private fun LifecycleCoroutineScope.collectItemCheckList() = launch {
        viewModel.itemCheckList.collectLatest {
            adapter.updateItemCheckedContainer(it)
        }
    }

    private fun LifecycleCoroutineScope.collectRecyclerViewItem() = launch {
        viewModel.images.collectLatest {
            adapter.submitData(it)
        }
    }
}