package com.natakorn.weatherforecast.main.datasource.network

import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastApi {

	@GET("data/2.5/weather")
	suspend fun toDayForecastRequest(
		@Query("q") cityName: String,
		@Query("units") units: String,
		@Query("appid") appId: String
	): Response<ToDayForecastResponseModel>

	@GET("data/2.5/forecast")
	suspend fun wholeDayForecastRequest(
		@Query("q") cityName: String,
		@Query("units") units: String,
		@Query("appid") appId: String,
		@Query("cnt") numberListToShow: String
	): Response<WholeDayForecastResponseModel>
}