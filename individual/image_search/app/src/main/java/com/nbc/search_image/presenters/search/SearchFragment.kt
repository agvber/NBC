package com.nbc.search_image.presenters.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.nbc.search_image.databinding.FragmentSearchBinding
import com.nbc.search_image.presenters.search.adapter.ImageSearchListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

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
        reloadEditTextState()
        initRecyclerView()
        collectSearchItem()
        syncEditTextState()
        binding.searchButton.setOnClickListener { hideKeyboard() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun reloadEditTextState() = lifecycleScope.launch {
        viewModel.recentSearchQueries.firstOrNull()
            ?.firstOrNull()?.let {
                binding.searchEditText.setText(it.query)
            }
    }

    private fun initRecyclerView() {
        binding.searchRecyclerView.adapter = ImageSearchListAdapter(viewModel::bookmarkItem)
        binding.searchRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun collectSearchItem() = lifecycleScope.launch {
        viewModel.search.collectLatest {
            (binding.searchRecyclerView.adapter as ImageSearchListAdapter)
                .submitData(it)
        }
    }

    private fun syncEditTextState() {
        binding.searchEditText.addTextChangedListener {
            viewModel.updateQuery(it?.toString() ?: return@addTextChangedListener)
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}