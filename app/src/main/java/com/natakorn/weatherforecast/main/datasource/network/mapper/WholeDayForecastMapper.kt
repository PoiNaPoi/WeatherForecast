package com.natakorn.weatherforecast.main.datasource.network.mapper

import com.natakorn.weatherforecast.core.network.exception.BaseRemoteException
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject

class WholeDayForecastMapper @Inject constructor() :
	Function<Response<WholeDayForecastResponseModel>> {

	fun apply(response: Response<WholeDayForecastResponseModel>): WholeDayForecastResponseModel {
		return when (response.code()) {
			HttpURLConnection.HTTP_OK -> requestToDayForecast(response)
			else -> throw BaseRemoteException(
				code = response.code(),
				msg = response.message()
			)
		}
	}

	private fun requestToDayForecast(
		response: Response<WholeDayForecastResponseModel>
	): WholeDayForecastResponseModel {
		return response.body() ?: throw BaseRemoteException(
			code = response.code(),
			msg = response.message()
		)
	}
}