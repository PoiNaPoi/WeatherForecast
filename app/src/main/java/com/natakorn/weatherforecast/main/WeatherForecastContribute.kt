package com.natakorn.weatherforecast.main

import com.natakorn.weatherforecast.main.presenter.WeatherForecastActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherForecastContribute {
	@ContributesAndroidInjector(
		modules = []
	)
	abstract fun contributeWeatherForecastActivity(): WeatherForecastActivity
}