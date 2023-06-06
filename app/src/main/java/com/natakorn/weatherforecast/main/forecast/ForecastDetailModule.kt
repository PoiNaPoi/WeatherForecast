package com.natakorn.weatherforecast.main.forecast

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.domain.GetToDayForecastUseCase
import com.natakorn.weatherforecast.main.forecast.presenter.ForecastDetailFragment
import com.natakorn.weatherforecast.main.forecast.presenter.ForecastDetailViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ForecastDetailModule {

	@Provides
	fun provideActivity(fragment: ForecastDetailFragment): Activity = fragment.requireActivity()

	@Provides
	fun provideFragment(fragment: ForecastDetailFragment): Fragment = fragment

	@Provides
	fun provideViewModel(fragment: ForecastDetailFragment): ViewModel =
		ViewModelProvider(fragment)[
				ForecastDetailFragment::class.java.name,
				ForecastDetailViewModel::class.java
		]

	@Named(GET_TODAY_FORECAST_USE_CASE)
	@Provides
	fun provideGetToDayForecastUseCase(getToDayForecastUseCase: GetToDayForecastUseCase):
			FlowResultUseCase<ToDayForecastRequestModel, ToDayForecastResponseModel> =
		getToDayForecastUseCase

	companion object {
		const val GET_TODAY_FORECAST_USE_CASE = "GET_TODAY_FORECAST_USE_CASE"
	}
}