package com.natakorn.weatherforecast.core.base.binding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.natakorn.weatherforecast.core.base.BaseActivity

abstract class BaseActivityBinding<VB : ViewBinding> : BaseActivity() {

	private var _binding: ViewBinding? = null
	val binding: VB
		get() = _binding as VB

	abstract val bindingInflater: (LayoutInflater) -> VB

	abstract fun setup()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = bindingInflater.invoke(layoutInflater)
		setContentView(binding.root)
		initData()
		setup()
		observable()
		initListener()
	}

	protected open fun initData() {
		// Override for data initiative
	}

	protected open fun observable() {
		// Override for observable
	}

	protected open fun initListener() {
		// Override for init view listener
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}