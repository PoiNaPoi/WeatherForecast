package com.natakorn.weatherforecast.main.wholeday.presenter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.natakorn.weatherforecast.main.datasource.model.WholeDayWeatherData
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum
import javax.inject.Inject

class WholeDayForecastAdapter @Inject constructor() :
	ListAdapter<WholeDayWeatherData, WholeDayForecastViewHolder>(
		WholeDayForecastDiffCallback()
	) {

	var temperatureUnit: ForecastUnitTypeRequestEnum = ForecastUnitTypeRequestEnum.METRIC

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WholeDayForecastViewHolder {
		return WholeDayForecastViewHolder.newInstance(parent)
	}

	override fun onBindViewHolder(holder: WholeDayForecastViewHolder, position: Int) {
		holder.bind(
			dayForecastData = getItem(position),
			temperatureUnit = temperatureUnit
		)
	}
}