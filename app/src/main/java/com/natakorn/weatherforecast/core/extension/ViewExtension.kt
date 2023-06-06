package com.natakorn.weatherforecast.core.extension

import android.os.SystemClock
import android.view.View

fun View.setOnClickWithDebounce(debounceTime: Long = 1000L, onClick: () -> Unit) {
	this.setOnClickListener(object : View.OnClickListener {
		private var lastClickTime: Long = 0
		override fun onClick(v: View) {
			if (SystemClock.elapsedRealtime() - lastClickTime >= debounceTime) {
				onClick.invoke()
				lastClickTime = SystemClock.elapsedRealtime()
			}
		}
	})
}

fun View?.visible() {
	this?.let {
		it.visibility = View.VISIBLE
	}
}

fun View?.gone() {
	this?.let {
		it.visibility = View.GONE
	}
}