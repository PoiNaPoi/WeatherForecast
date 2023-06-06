package com.natakorn.weatherforecast.core.network.exception

data class BaseRemoteException(val code: Int = 500, val msg: String? = "") :
	Throwable(message = msg)