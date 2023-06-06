package com.natakorn.weatherforecast.main

import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSourceModule
import com.natakorn.weatherforecast.main.presenter.WeatherForecastActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherForecastContribute {
	@ContributesAndroidInjector(
		modules = [
			WeatherForecastDataSourceModule::class
		]
	)
	abstract fun contributeWeatherForecastActivity(): WeatherForecastActivity
}