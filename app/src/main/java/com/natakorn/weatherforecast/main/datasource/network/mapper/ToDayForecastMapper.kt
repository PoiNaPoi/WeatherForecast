package com.natakorn.weatherforecast.main.datasource.network.mapper

import com.natakorn.weatherforecast.core.network.exception.BaseRemoteException
import com.natakorn.weatherforecast.main.datasource.exception.WeatherForecastCityNotFoundException
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class ToDayForecastMapper @Inject constructor() : Function<Response<ToDayForecastResponseModel>> {

	fun apply(response: Response<ToDayForecastResponseModel>): ToDayForecastResponseModel {
		return when (response.code()) {
			HttpURLConnection.HTTP_OK -> requestToDayForecast(response)
			HttpURLConnection.HTTP_NOT_FOUND -> throw WeatherForecastCityNotFoundException(
				code = response.code(),
				msg = response.message()
			)

			else -> throw BaseRemoteException(
				code = response.code(),
				msg = response.message()
			)
		}
	}

	private fun requestToDayForecast(
		response: Response<ToDayForecastResponseModel>
	): ToDayForecastResponseModel {
		return response.body() ?: throw BaseRemoteException(
			code = response.code(),
			msg = response.message()
		)
	}
}