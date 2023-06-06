package com.natakorn.weatherforecast.main.datasource.model

data class WholeDayForecastRequestModel(
	val cityName: String = "",
	val units: String = "",
	val numberTimestamps: Int = 8
)