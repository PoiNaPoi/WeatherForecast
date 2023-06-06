package com.natakorn.weatherforecast.main.datasource

import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import kotlinx.coroutines.flow.Flow

interface WeatherForecastDataSource {
	fun getToDayForecast(request: ToDayForecastRequestModel): Flow<ToDayForecastResponseModel>
	fun getWholeDayForecast(request: WholeDayForecastRequestModel): Flow<WholeDayForecastResponseModel>
}