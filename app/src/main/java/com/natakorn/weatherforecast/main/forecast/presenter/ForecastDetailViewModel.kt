package com.natakorn.weatherforecast.main.forecast.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natakorn.weatherforecast.core.extension.runOn
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.exception.WeatherForecastCityNotFoundException
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum
import com.natakorn.weatherforecast.main.forecast.ForecastDetailModule
import javax.inject.Inject
import javax.inject.Named

class ForecastDetailViewModel @Inject constructor(
	@Named(ForecastDetailModule.GET_TODAY_FORECAST_USE_CASE)
	private val getToDayForecastUseCase: FlowResultUseCase<ToDayForecastRequestModel, ToDayForecastResponseModel>
) : ViewModel() {

	private val _toDayForeCast = MutableLiveData<ToDayForecastResponseModel>()
	val toDayForeCast: LiveData<ToDayForecastResponseModel> = _toDayForeCast

	private val _displayPleaseFillCity = MutableLiveData<Unit>()
	val displayPleaseFillCity: LiveData<Unit> = _displayPleaseFillCity

	private val _cityNotFound = MutableLiveData<Throwable>()
	val cityNotFound: LiveData<Throwable> = _cityNotFound

	private val _otherError = MutableLiveData<Throwable>()
	val otherError: LiveData<Throwable> = _otherError

	var isGetToDayDateSuccess: Boolean = false
	var temperatureUnit: ForecastUnitTypeRequestEnum = ForecastUnitTypeRequestEnum.METRIC
	var inputCityName: String = ""

	fun getWeatherDetail(
		cityName: String,
		unit: ForecastUnitTypeRequestEnum
	) {
		if (cityName.isEmpty()) {
			_displayPleaseFillCity.postValue(Unit)
		} else {
			val requestModel = ToDayForecastRequestModel(
				cityName = cityName,
				units = unit.field
			)

			getToDayForecastUseCase.invoke(request = requestModel)
				.runOn(viewModelScope) { result ->
					result.onSuccess { toDayData ->
						getToDayForecastSuccess(toDayData)
					}.onFailure { throwable ->
						getToDayForecastError(throwable)
					}
				}
		}
	}

	fun switchStateChange(isFahrenheit: Boolean) {
		temperatureUnit = if (isFahrenheit) ForecastUnitTypeRequestEnum.IMPERIAL
		else ForecastUnitTypeRequestEnum.METRIC

		_toDayForeCast.value?.let {
			getWeatherDetail(
				cityName = it.name,
				unit = temperatureUnit
			)
		}
	}

	fun updateCityName(cityName: String) {
		inputCityName = cityName
	}

	private fun getToDayForecastSuccess(toDayData: ToDayForecastResponseModel) {
		isGetToDayDateSuccess = true
		_toDayForeCast.postValue(toDayData)
	}

	private fun getToDayForecastError(throwable: Throwable) {
		isGetToDayDateSuccess = false
		when (throwable) {
			is WeatherForecastCityNotFoundException -> _cityNotFound.postValue(throwable)
			else -> _otherError.postValue(throwable)
		}
	}
}