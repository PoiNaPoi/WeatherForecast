package com.natakorn.weatherforecast.main.domain

import com.natakorn.weatherforecast.core.di.IoDispatcher
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.WeatherForecastDataSource
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetToDayForecastUseCase @Inject constructor(
	private val dataSource: WeatherForecastDataSource,
	@IoDispatcher dispatcher: CoroutineDispatcher
) : FlowResultUseCase<ToDayForecastRequestModel, ToDayForecastResponseModel>(
	dispatcher
) {
	override fun execute(request: ToDayForecastRequestModel): Flow<ToDayForecastResponseModel> {
		return dataSource.getToDayForecast(request = request)
	}
}