package com.natakorn.weatherforecast.main.datasource

import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import kotlinx.coroutines.flow.Flow

interface WeatherForecastDataSource {
	fun getToDayForecast(request: ToDayForecastRequestModel): Flow<ToDayForecastResponseModel>
}