package com.natakorn.weatherforecast.main.datasource

import com.natakorn.weatherforecast.BuildConfig
import com.natakorn.weatherforecast.main.datasource.model.ToDayForecastResponseModel
import com.natakorn.weatherforecast.main.datasource.network.WeatherForecastApi
import com.natakorn.weatherforecast.main.datasource.network.WeatherForecastDataSourceNetwork
import com.natakorn.weatherforecast.main.datasource.network.mapper.ToDayForecastMapper
import dagger.Module
import dagger.Provides
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class WeatherForecastDataSourceModule {
	@Provides
	fun provideApi(): WeatherForecastApi =
		Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BuildConfig.WEATHER_HOST).build().create(WeatherForecastApi::class.java)

	@Provides
	fun provideDataSource(dataSourceNetwork: WeatherForecastDataSourceNetwork): WeatherForecastDataSource =
		WeatherForecastRepository(dataSourceNetwork)

	@Provides
	fun provideToDayForecastMapper(toDayForecastMapper: ToDayForecastMapper): Function<Response<ToDayForecastResponseModel>> =
		toDayForecastMapper
}