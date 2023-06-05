package com.natakorn.weatherforecast.main.forecast.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.natakorn.weatherforecast.core.base.binding.BaseFragmentBinding
import com.natakorn.weatherforecast.databinding.FragmentForecastDetailBinding

class ForecastDetailFragment : BaseFragmentBinding<FragmentForecastDetailBinding>() {
	override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForecastDetailBinding
		get() = FragmentForecastDetailBinding::inflate

	override fun setup() = Unit
}