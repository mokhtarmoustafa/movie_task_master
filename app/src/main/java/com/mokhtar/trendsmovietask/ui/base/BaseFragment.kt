package com.mokhtar.trendsmovietask.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {

    //region variables
    private var mViewBinding: VB? = null
    val binding: VB get() = mViewBinding!!
    protected abstract val mViewModel: VM
    //endregion


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mViewBinding = getViewBinding(container?.rootView!!)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        mViewBinding = getViewBinding(view)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewBinding = null
    }

    //endregion

    //region helper functions
    abstract fun getViewBinding(view: View): VB
    //endregion
}