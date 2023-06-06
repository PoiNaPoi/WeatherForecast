package com.natakorn.weatherforecast.main.domain

import com.natakorn.weatherforecast.core.di.IoDispatcher
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSource
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWholeDayForecastUseCase @Inject constructor(
	private val dataSource: WeatherForecastDataSource,
	@IoDispatcher dispatcher: CoroutineDispatcher
) : FlowResultUseCase<WholeDayForecastRequestModel, WholeDayForecastResponseModel>(
	dispatcher
) {
	override fun execute(request: WholeDayForecastRequestModel): Flow<WholeDayForecastResponseModel> {
		return dataSource.getWholeDayForecast(request = request)
	}
}