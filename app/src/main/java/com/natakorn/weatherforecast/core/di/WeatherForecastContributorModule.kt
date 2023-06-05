package com.natakorn.weatherforecast.core.di

import com.natakorn.weatherforecast.main.WeatherForecastContribute
import com.natakorn.weatherforecast.main.forecast.ForecastDetailContributor
import dagger.Module

@Module(
	includes = [
		WeatherForecastContribute::class,
		ForecastDetailContributor::class
	]
)
class WeatherForecastContributorModule