package com.tugceaksoy.earthquick.ui.main.earthquakebag

import android.os.Bundle
import android.view.View
import com.tugceaksoy.earthquick.databinding.FragmentBagBinding
import com.tugceaksoy.earthquick.ui.base.BaseFragment
import com.tugceaksoy.earthquick.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BagFragment : BaseFragment<FragmentBagBinding>(
    FragmentBagBinding::inflate
){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideLoading()
        binding.webview.loadUrl("https://www.afad.gov.tr/afet-ve-acil-durum-cantasi-nasil-hazirlanmali")
        binding.webview.settings.javaScriptEnabled=true
    }

}