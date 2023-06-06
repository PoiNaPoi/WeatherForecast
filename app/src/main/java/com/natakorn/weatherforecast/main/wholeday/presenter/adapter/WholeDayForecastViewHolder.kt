package com.natakorn.weatherforecast.main.wholeday.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natakorn.weatherforecast.R
import com.natakorn.weatherforecast.databinding.ItemWholeDayForecastBinding
import com.natakorn.weatherforecast.main.datasource.model.WholeDayWeatherData
import com.natakorn.weatherforecast.main.datasource.model.enum.ForecastUnitTypeRequestEnum

class WholeDayForecastViewHolder constructor(
	private val binding: ItemWholeDayForecastBinding
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		dayForecastData: WholeDayWeatherData,
		temperatureUnit: ForecastUnitTypeRequestEnum
	) {
		initView(
			dayForecastData = dayForecastData,
			temperatureUnit = temperatureUnit
		)
	}

	private fun initView(
		dayForecastData: WholeDayWeatherData,
		temperatureUnit: ForecastUnitTypeRequestEnum
	) {
		itemView.context.apply {
			binding.apply {
				itemWholeDayForecastDate.text = getText(R.string.whole_day_date_title_text)
					.toString().plus(dayForecastData.dateTime)

				itemWholeDayForecastTitle.text = getText(R.string.whole_day_weather_title_text)
					.toString().plus(dayForecastData.weather[0].weatherTitle)

				itemWholeDayForecastDescription.text =
					getText(R.string.whole_day_description_title_text)
						.toString().plus(dayForecastData.weather[0].weatherDescription)

				val temperatureString = when (temperatureUnit) {
					ForecastUnitTypeRequestEnum.METRIC -> {
						getText(R.string.whole_day_temperature_title_text).toString()
							.plus(dayForecastData.weatherData.temp)
							.plus(TEMPERATURE_CELSIUS_UNIT)
					}

					ForecastUnitTypeRequestEnum.IMPERIAL -> {
						getText(R.string.whole_day_temperature_title_text).toString()
							.plus(dayForecastData.weatherData.temp)
							.plus(TEMPERATURE_FAHRENHEIT_UNIT)
					}
				}

				itemWholeDayForecastTemperature.text = temperatureString

				itemWholeDayForecastHumidity.text = getText(R.string.whole_day_humidity_title_text)
					.toString().plus(dayForecastData.weatherData.humidity)
					.plus(HUMIDITY_UNIT)
			}
		}
	}

	companion object {
		const val HUMIDITY_UNIT = " %"
		const val TEMPERATURE_CELSIUS_UNIT = " °C"
		const val TEMPERATURE_FAHRENHEIT_UNIT = " °F"

		fun newInstance(parent: ViewGroup): WholeDayForecastViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = ItemWholeDayForecastBinding.inflate(inflater, parent, false)
			return WholeDayForecastViewHolder(binding)
		}
	}
}