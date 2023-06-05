package com.natakorn.weatherforecast.main.presenter

import android.view.LayoutInflater
import com.natakorn.weatherforecast.core.base.binding.BaseActivityBinding
import com.natakorn.weatherforecast.databinding.ActivityMainBinding

class WeatherForecastActivity : BaseActivityBinding<ActivityMainBinding>() {
	override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
		get() = ActivityMainBinding::inflate

	override fun setup() = Unit
}