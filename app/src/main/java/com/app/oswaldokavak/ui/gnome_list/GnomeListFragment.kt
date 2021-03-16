package com.app.oswaldokavak.ui.gnome_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.oswaldokavak.R
import com.app.oswaldokavak.data.api.response.BrastiewarkResponse
import com.app.oswaldokavak.data.model.Brastlewark
import com.app.oswaldokavak.data.remote.RemoteDataSourceImpl
import com.app.oswaldokavak.databinding.FragmentGnomeListBinding
import com.app.oswaldokavak.domain.RepoImpl
import com.app.oswaldokavak.ui.gnome_list.adapter.GnomeListAdapter
import com.app.oswaldokavak.ui.gnome_list.adapter.IGnomeListEvent
import com.app.oswaldokavak.ui.gnome_list.viewmodel.GnomeListViewModel
import com.app.oswaldokavak.ui.gnome_list.viewmodel.VMGnomeList
import com.app.oswaldokavak.utils.Resource

class GnomeListFragment : Fragment(), IGnomeListEvent {

    private val viewModel by viewModels<GnomeListViewModel> { VMGnomeList( RepoImpl( RemoteDataSourceImpl()  ) ) }

    private var _binding: FragmentGnomeListBinding? = null
    private val binding get() = _binding!!
    private val gnomeListAdapter: GnomeListAdapter = GnomeListAdapter()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGnomeListBinding.inflate(inflater, container, false)
        val view = binding.root

        initRecyclerView()
        setupObservers()
        viewModel.attemptGetList()

        return view
    }

    private fun initRecyclerView() {
        binding.rvGnoms.setHasFixedSize(true)
        binding.rvGnoms.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun setupObservers() {
        viewModel.gnomeList.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    setData(result.data.brastlewark)
                }
                is Resource.Failure -> {
                    hideLoading()
                }
            }
        })
    }

    private fun setData(brastlewarks: List<Brastlewark>) {
        gnomeListAdapter.recyclerAdapter(brastlewarks, requireActivity(), this)
        binding.rvGnoms.adapter = gnomeListAdapter
        hideLoading()
    }

    private fun showLoading(){
        binding.progressLoading.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.progressLoading.visibility = View.GONE
    }

    override fun onGnomeClick(item: Brastlewark) {
        val bundle = Bundle()
        bundle.putParcelable("gnome",item)
        findNavController().navigate(R.id.action_gnomeListFragment_to_gnomeDetailFragment, bundle)
    }

}