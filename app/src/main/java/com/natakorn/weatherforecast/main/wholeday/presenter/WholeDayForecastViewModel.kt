package com.natakorn.weatherforecast.main.wholeday.presenter

import androidx.lifecycle.ViewModel
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum
import javax.inject.Inject

class WholeDayForecastViewModel @Inject constructor() : ViewModel() {

	var cityName: String = ""
	var temperatureUnit: ForecastUnitTypeRequestEnum = ForecastUnitTypeRequestEnum.METRIC
}