package com.natakorn.weatherforecast.main.wholeday.presenter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.natakorn.weatherforecast.main.datasource.model.WholeDayWeatherData

class WholeDayForecastDiffCallback : DiffUtil.ItemCallback<WholeDayWeatherData>() {
	override fun areItemsTheSame(
		oldItem: WholeDayWeatherData,
		newItem: WholeDayWeatherData
	): Boolean {
		return oldItem == newItem
	}

	override fun areContentsTheSame(
		oldItem: WholeDayWeatherData,
		newItem: WholeDayWeatherData
	): Boolean {
		return oldItem == newItem
	}
}