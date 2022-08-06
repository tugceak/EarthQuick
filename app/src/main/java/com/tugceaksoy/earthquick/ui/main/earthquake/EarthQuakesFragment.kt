package com.tugceaksoy.earthquick.ui.main.earthquake

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugceaksoy.earthquick.data.model.Output
import com.tugceaksoy.earthquick.databinding.FragmentEarthQuakesBinding
import com.tugceaksoy.earthquick.ui.main.MainActivity
import com.tugceaksoy.earthquick.ui.base.BaseFragment
import com.tugceaksoy.earthquick.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EarthQuakesFragment : BaseFragment<FragmentEarthQuakesBinding>(
    FragmentEarthQuakesBinding::inflate
) {
    private val earthQuakesAdapter by lazy { EarthquakesAdapter(arrayListOf()) }
    private val eaViewModel: EarthQuakesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        loadData()
    }
    private fun initView() {
        binding.swipeRefreshLayout.setOnRefreshListener { loadData() }
        binding.rw.adapter = earthQuakesAdapter
        binding.rw.layoutManager = LinearLayoutManager(requireContext())

    }
    private fun initObserver() {
        eaViewModel.postQuakes.observe(viewLifecycleOwner, { earthQuake ->
            when (earthQuake.status) {
                Output.Status.SUCCESS -> {
                    earthQuake.data?.let {
                        earthQuakesAdapter.setEarthQuakeList(it)
                        binding.swipeRefreshLayout.isRefreshing=false
                        (activity as MainActivity).hideLoading()

                    }
                }
                Output.Status.ERROR -> {
                    (activity as MainActivity).hideLoading()

                }
                Output.Status.LOADING -> {
                    (activity as MainActivity).showLoading()
                }
            }

        })

    }


    private fun loadData() {
        lifecycleScope.launch {
            if (Utils.isNetworkAvailable(requireContext())) {
                binding.run {
                    eaViewModel.getEarthQuakes()
                }
            }
        }
    }

}