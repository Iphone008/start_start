package com.example.start_go.Base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

abstract class  BaseFragmet : Fragment(){
    private var isViewPrepare = false

    /**
     * 数据是否加载过了
     */

    private var hasLoadData = false

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
    }

    open fun startTo(targetClass: Class<out Activity>) {
        val intent = Intent(context, targetClass)
        context?.startActivity(intent)
    }

    open fun startTo(intent: Intent) {
        context?.startActivity(intent)
    }


    private lateinit var alertDialog: AlertDialog
    fun isAlertDialogInit() = ::alertDialog.isInitialized

    abstract fun getLayoutId(): Int

    abstract fun initInjector()
    abstract fun initView()
    abstract fun lazyLoadData()
}