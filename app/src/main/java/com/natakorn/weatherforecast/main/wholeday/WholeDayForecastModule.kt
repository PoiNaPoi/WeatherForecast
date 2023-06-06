package com.natakorn.weatherforecast.main.wholeday

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natakorn.weatherforecast.main.wholeday.presenter.WholeDayForecastFragment
import com.natakorn.weatherforecast.main.wholeday.presenter.WholeDayForecastViewModel
import dagger.Module
import dagger.Provides

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
}