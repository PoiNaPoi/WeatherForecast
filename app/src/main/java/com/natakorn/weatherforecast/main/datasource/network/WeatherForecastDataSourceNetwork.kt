package com.natakorn.weatherforecast.main.datasource.network

import com.natakorn.weatherforecast.BuildConfig
import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSource
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.network.mapper.ToDayForecastMapper
import com.natakorn.weatherforecast.main.datasource.network.mapper.WholeDayForecastMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherForecastDataSourceNetwork @Inject constructor(
	private val api: WeatherForecastApi,
	private val toDayForecastMapper: ToDayForecastMapper,
	private val wholeDayForecastMapper: WholeDayForecastMapper
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

	override fun getWholeDayForecast(request: WholeDayForecastRequestModel): Flow<WholeDayForecastResponseModel> {
		return flow {
			val response = api.wholeDayForecastRequest(
				cityName = request.cityName,
				units = request.units,
				appId = BuildConfig.WEATHER_API_KEY,
				numberListToShow = NUMBER_OF_LIST_TO_SHOW
			)
			emit(wholeDayForecastMapper.apply(response = response))
		}
	}

	companion object {
		const val NUMBER_OF_LIST_TO_SHOW = "8"
	}
}