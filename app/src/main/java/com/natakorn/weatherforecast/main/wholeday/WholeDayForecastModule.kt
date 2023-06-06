package com.natakorn.weatherforecast.main.wholeday

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natakorn.weatherforecast.core.network.usecase.FlowResultUseCase
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastRequestModel
import com.natakorn.weatherforecast.main.datasource.model.WholeDayForecastResponseModel
import com.natakorn.weatherforecast.main.domain.GetWholeDayForecastUseCase
import com.natakorn.weatherforecast.main.wholeday.presenter.WholeDayForecastFragment
import com.natakorn.weatherforecast.main.wholeday.presenter.WholeDayForecastViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class WholeDayForecastModule {

	@Provides
	fun provideActivity(fragment: WholeDayForecastFragment): Activity = fragment.requireActivity()

	@Provides
	fun provideFragment(fragment: WholeDayForecastFragment): Fragment = fragment

	@Provides
	fun provideViewModel(fragment: WholeDayForecastFragment): ViewModel =
		ViewModelProvider(fragment)[
				WholeDayForecastFragment::class.java.name,
				WholeDayForecastViewModel::class.java
		]

	@Named(GET_WHOLE_DAY_FORECAST_USE_CASE)
	@Provides
	fun provideGetToDayForecastUseCase(getWholeDayForecastUseCase: GetWholeDayForecastUseCase):
			FlowResultUseCase<WholeDayForecastRequestModel, WholeDayForecastResponseModel> =
		getWholeDayForecastUseCase

	companion object {
		const val GET_WHOLE_DAY_FORECAST_USE_CASE = "GET_WHOLE_DAY_FORECAST_USE_CASE"
	}
}