package com.natakorn.weatherforecast.main.datasource.network

import com.natakorn.weatherforecast.BuildConfig
import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSource
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.network.mapper.ToDayForecastMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherForecastDataSourceNetwork @Inject constructor(
	private val api: WeatherForecastApi,
	private val toDayForecastMapper: ToDayForecastMapper
) : WeatherForecastDataSource {

	override fun getToDayForecast(request: ToDayForecastRequestModel): Flow<ToDayForecastResponseModel> {
		return flow {
			val response = api.toDayForecastRequest(
				cityName = request.cityName,
				units = request.units,
				appId = BuildConfig.WEATHER_API_KEY
			)
			emit(toDayForecastMapper.apply(response = response))
		}
	}
}