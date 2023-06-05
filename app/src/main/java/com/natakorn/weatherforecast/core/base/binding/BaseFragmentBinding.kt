package com.natakorn.weatherforecast.core.base.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.natakorn.weatherforecast.core.base.BaseFragment

abstract class BaseFragmentBinding<VB : ViewBinding> : BaseFragment() {
	private var _binding: ViewBinding? = null
	val binding: VB
		get() = _binding as VB

	abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

	abstract fun setup()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		initData()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = bindingInflater.invoke(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
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