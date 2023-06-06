package com.natakorn.weatherforecast.main.forecast.presenter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import com.natakorn.weatherforecast.R
import com.natakorn.weatherforecast.core.base.binding.BaseFragmentBinding
import com.natakorn.weatherforecast.core.extension.gone
import com.natakorn.weatherforecast.core.extension.setOnClickWithDebounce
import com.natakorn.weatherforecast.core.extension.visible
import com.natakorn.weatherforecast.databinding.FragmentForecastDetailBinding
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum
import javax.inject.Inject

class ForecastDetailFragment : BaseFragmentBinding<FragmentForecastDetailBinding>() {

	@Inject
	lateinit var viewModel: ForecastDetailViewModel

	override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForecastDetailBinding
		get() = FragmentForecastDetailBinding::inflate

	override fun setup() {
		showWelcomeMessage()
	}

	override fun initListener() {
		super.initListener()

		binding.apply {
			searchIcon.setOnClickWithDebounce() {
				viewModel.getWeatherDetail(
					cityName = viewModel.inputCityName,
					unit = viewModel.temperatureUnit
				)
			}

			tempSwitch.setOnCheckedChangeListener { _, isFahrenheit ->
				viewModel.switchStateChange(isFahrenheit = isFahrenheit)
			}

			textSearch.addTextChangedListener(object :
				TextWatcher {
				override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
					// Non implement
				}

				override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
					// Non implement
				}

				override fun afterTextChanged(string: Editable?) {
					viewModel.updateCityName(string.toString())
				}
			})
		}
	}

	override fun observable() {
		super.observable()

		viewModel.toDayForeCast.observe(this) { toDayData ->
			displayResult(toDayData = toDayData)
		}

		viewModel.cityNotFound.observe(this) { throwable ->
			displayErrorMessage(
				throwable = throwable,
				message = getText(R.string.other_error_text).toString()
			)
		}

		viewModel.otherError.observe(this) { throwable ->
			displayErrorMessage(
				throwable = throwable,
				message = getText(R.string.other_error_text).toString()
			)
		}

		viewModel.displayPleaseFillCity.observe(this) {
			displayErrorMessage(
				message = getText(R.string.remind_fill_city_text).toString()
			)
		}
	}

	private fun displayResult(toDayData: ToDayForecastResponseModel) {
		binding.apply {
			temperatureTitle.visible()
			temperatureDisplay.visible()
			humidityTitle.visible()
			humidityDisplay.visible()

			cityDisplay.text = toDayData.name

			val temperatureString = when (viewModel.temperatureUnit) {
				ForecastUnitTypeRequestEnum.METRIC -> {
					toDayData.weatherData.temp.toString().plus(TEMPERATURE_CELSIUS_UNIT)
				}

				ForecastUnitTypeRequestEnum.IMPERIAL -> {
					toDayData.weatherData.temp.toString().plus(TEMPERATURE_FAHRENHEIT_UNIT)
				}
			}

			temperatureDisplay.text = temperatureString
			humidityDisplay.text = toDayData.weatherData.humidity.toString().plus(HUMIDITY_UNIT)
		}
	}

	private fun displayErrorMessage(
		throwable: Throwable? = null,
		message: String = ""
	) {
		setViewGone()
		binding.cityDisplay.text = throwable?.message ?: message
	}

	private fun setViewGone() {
		binding.apply {
			temperatureTitle.gone()
			temperatureDisplay.gone()
			humidityTitle.gone()
			humidityDisplay.gone()
		}
	}

	private fun showWelcomeMessage() {
		setViewGone()

		context.let {
			binding.cityDisplay.text = getText(R.string.welcome_message_text)
		}
	}

	companion object {
		const val HUMIDITY_UNIT = " %"
		const val TEMPERATURE_CELSIUS_UNIT = " °C"
		const val TEMPERATURE_FAHRENHEIT_UNIT = " °F"
	}
}