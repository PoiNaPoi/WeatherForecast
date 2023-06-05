package com.natakorn.weatherforecast

import com.natakorn.weatherforecast.core.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class WeatherForecastApplication : DaggerApplication() {
	override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
		return DaggerAppComponent.factory().create(this)
	}
}