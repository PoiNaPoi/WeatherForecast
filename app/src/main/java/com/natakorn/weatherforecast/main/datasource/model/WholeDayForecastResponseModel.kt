package com.natakorn.weatherforecast.main.datasource.model

import com.google.gson.annotations.SerializedName
import java.net.HttpURLConnection

data class WholeDayForecastResponseModel(
	@SerializedName("cod") val code: String = HttpURLConnection.HTTP_OK.toString(),
	@SerializedName("message") val message: String = "",
	@SerializedName("list") val wholeDayWeatherData: List<WholeDayWeatherData> = listOf()
)

data class WholeDayWeatherData(
	@SerializedName("main") val weatherData: WeatherData = WeatherData(),
	@SerializedName("weather") val weather: List<WeatherForecastData> = listOf(),
	@SerializedName("dt_txt") val dateTime: String = ""
)

data class WeatherForecastData(
	@SerializedName("main") val weatherTitle: String = "",
	@SerializedName("description") val weatherDescription: String = ""
)