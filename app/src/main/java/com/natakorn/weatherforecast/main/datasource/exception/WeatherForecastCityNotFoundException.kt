package com.natakorn.weatherforecast.main.datasource.exception

class WeatherForecastCityNotFoundException(val code: Int = 404, val msg: String? = "") :
	Throwable(message = msg)