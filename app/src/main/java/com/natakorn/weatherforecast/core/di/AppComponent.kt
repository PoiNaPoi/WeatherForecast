package com.natakorn.weatherforecast.core.di

import com.natakorn.weatherforecast.WeatherForecastApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AndroidSupportInjectionModule::class,
		DispatcherModule::class,
		WeatherForecastContributorModule::class
	]
)
interface AppComponent : AndroidInjector<WeatherForecastApplication> {
	@Component.Factory
	interface Factory : AndroidInjector.Factory<WeatherForecastApplication>
}