package com.nbc.search_image.presenters.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.nbc.search_image.databinding.FragmentBookmarkBinding
import com.nbc.search_image.presenters.bookmark.adapter.BookmarkListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookmarkFragment : Fragment() {
    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookmarkViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        collectBookmarkItems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.bookmarkRecyclerView.adapter = BookmarkListAdapter(viewModel::deleteBookmark)
        binding.bookmarkRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun collectBookmarkItems() = lifecycleScope.launch {
        viewModel.bookmarks.collectLatest {
            (binding.bookmarkRecyclerView.adapter as BookmarkListAdapter)
                .submitList(it)
        }
    }
}