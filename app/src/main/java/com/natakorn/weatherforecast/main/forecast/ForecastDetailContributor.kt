package com.natakorn.weatherforecast.main.forecast

import com.natakorn.weatherforecast.main.forecast.presenter.ForecastDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ForecastDetailContributor {
	@ContributesAndroidInjector(
		modules = [
			ForecastDetailModule::class
		]
	)
	abstract fun contributeForecastDetailFragment(): ForecastDetailFragment
}