package com.natakorn.weatherforecast.main.datasource

class WeatherForecastRepository constructor(
	private val weatherForecastDataSource: WeatherForecastDataSource
) : WeatherForecastDataSource by weatherForecastDataSource