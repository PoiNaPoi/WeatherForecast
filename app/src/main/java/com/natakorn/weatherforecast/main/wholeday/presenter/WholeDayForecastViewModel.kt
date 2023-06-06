package com.natakorn.weatherforecast.main.wholeday.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natakorn.weatherforecast.core.extension.runOn
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayWeatherData
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum
import com.natakorn.weatherforecast.main.wholeday.WholeDayForecastModule
import javax.inject.Inject
import javax.inject.Named

class WholeDayForecastViewModel @Inject constructor(
	@Named(WholeDayForecastModule.GET_WHOLE_DAY_FORECAST_USE_CASE)
	private val getWholeDayForecastUseCase: FlowResultUseCase<WholeDayForecastRequestModel, WholeDayForecastResponseModel>
) : ViewModel() {

	private val _wholeDayForeCast = MutableLiveData<List<WholeDayWeatherData>>()
	val wholeDayForeCast: LiveData<List<WholeDayWeatherData>> = _wholeDayForeCast

	var cityName: String = ""
	var temperatureUnit: ForecastUnitTypeRequestEnum = ForecastUnitTypeRequestEnum.METRIC

	fun getWholeDayForecast(
		cityName: String,
		temperatureUnit: ForecastUnitTypeRequestEnum
	) {
		val requestModel = WholeDayForecastRequestModel(
			cityName = cityName,
			units = temperatureUnit.field
		)

		getWholeDayForecastUseCase.invoke(request = requestModel)
			.runOn(viewModelScope) { result ->
				result.onSuccess { wholeDayData ->
					getWholeDayForecastSuccess(wholeDayData = wholeDayData)
				}.onFailure {

				}
			}
	}

	private fun getWholeDayForecastSuccess(wholeDayData: WholeDayForecastResponseModel) {
		_wholeDayForeCast.postValue(wholeDayData.wholeDayWeatherData)
	}
}