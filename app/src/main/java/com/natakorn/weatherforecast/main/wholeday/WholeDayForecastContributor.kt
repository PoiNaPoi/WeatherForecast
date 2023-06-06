package com.natakorn.weatherforecast.main.wholeday

import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSourceModule
import com.natakorn.weatherforecast.main.wholeday.presenter.WholeDayForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WholeDayForecastContributor {
	@ContributesAndroidInjector(
		modules = [
			WholeDayForecastModule::class,
			WeatherForecastDataSourceModule::class
		]
	)
	abstract fun contributeWholeDayForecastFragment(): WholeDayForecastFragment
}