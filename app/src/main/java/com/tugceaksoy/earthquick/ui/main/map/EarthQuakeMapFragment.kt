package com.tugceaksoy.earthquick.ui.main.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tugceaksoy.earthquick.R
import com.tugceaksoy.earthquick.databinding.FragmentEarthQuakeMapBinding
import com.tugceaksoy.earthquick.ui.base.BaseFragment
import com.tugceaksoy.earthquick.ui.main.MainActivity

class EarthQuakeMapFragment : BaseFragment<FragmentEarthQuakeMapBinding>(
    FragmentEarthQuakeMapBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideLoading()
    }

}