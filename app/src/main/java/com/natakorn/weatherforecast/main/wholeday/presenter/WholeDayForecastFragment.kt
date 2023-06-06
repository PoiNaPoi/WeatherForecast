package com.natakorn.weatherforecast.main.wholeday.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.natakorn.weatherforecast.core.base.binding.BaseFragmentBinding
import com.natakorn.weatherforecast.core.extension.setOnClickWithDebounce
import com.natakorn.weatherforecast.databinding.FragmentWholeDayForecastBinding
import com.natakorn.weatherforecast.main.wholeday.presenter.adapter.WholeDayForecastAdapter
import javax.inject.Inject

class WholeDayForecastFragment : BaseFragmentBinding<FragmentWholeDayForecastBinding>() {

	@Inject
	lateinit var viewModel: WholeDayForecastViewModel

	@Inject
	lateinit var adapter: WholeDayForecastAdapter

	override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWholeDayForecastBinding
		get() = FragmentWholeDayForecastBinding::inflate

	override fun setup() {
		setUpAdapter()
	}

	override fun initData() {
		super.initData()

		arguments?.let { bundle ->
			WholeDayForecastFragmentArgs.fromBundle(bundle).apply {
				viewModel.cityName = cityName
				viewModel.temperatureUnit = temperatureUnit
			}
		}
	}

	override fun initListener() {
		super.initListener()

		binding.wholeDayForecastBackButton.setOnClickWithDebounce {
			findNavController().popBackStack()
		}
	}

	private fun setUpAdapter() {
		binding.wholeDayForecastRecyclerView.adapter = adapter
		adapter.temperatureUnit = viewModel.temperatureUnit
	}
}