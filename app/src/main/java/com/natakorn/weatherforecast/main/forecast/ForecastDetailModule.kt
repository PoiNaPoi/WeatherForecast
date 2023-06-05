package com.natakorn.weatherforecast.main.forecast

import android.app.Activity
import androidx.fragment.app.Fragment
import com.natakorn.weatherforecast.main.forecast.presenter.ForecastDetailFragment
import dagger.Module
import dagger.Provides

@Module
class ForecastDetailModule {

	@Provides
	fun provideActivity(fragment: ForecastDetailFragment): Activity = fragment.requireActivity()

	@Provides
	fun provideFragment(fragment: ForecastDetailFragment): Fragment = fragment
}