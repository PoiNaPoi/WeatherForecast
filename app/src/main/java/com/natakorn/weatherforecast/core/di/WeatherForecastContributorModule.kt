package com.natakorn.weatherforecast.core.di

import com.natakorn.weatherforecast.main.WeatherForecastContribute
import com.natakorn.weatherforecast.main.forecast.ForecastDetailContributor
import com.natakorn.weatherforecast.main.wholeday.WholeDayForecastContributor
import dagger.Module

@Module(
	includes = [
		WeatherForecastContribute::class,
		ForecastDetailContributor::class,
		WholeDayForecastContributor::class
	]
)
class WeatherForecastContributorModule