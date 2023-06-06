package com.natakorn.weatherforecast.main.datasource.model

import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum

class ToDayForecastRequestModel(
	val cityName: String = "",
	val units: String = ForecastUnitTypeRequestEnum.METRIC.field,
)