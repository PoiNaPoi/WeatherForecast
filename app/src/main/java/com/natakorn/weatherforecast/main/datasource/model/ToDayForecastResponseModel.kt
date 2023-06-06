package com.natakorn.weatherforecast.main.datasource.model

import com.google.gson.annotations.SerializedName
import java.net.HttpURLConnection

data class ToDayForecastResponseModel(
	@SerializedName("cod") val code: String = HttpURLConnection.HTTP_OK.toString(),
	@SerializedName("message") val message: String = "",
	@SerializedName("name") val name: String = "",
	@SerializedName("main") val weatherData: WeatherData = WeatherData()
)

data class WeatherData(
	@SerializedName("temp") val temp: Double = 0.0,
	@SerializedName("humidity") val humidity: Int = 0
)