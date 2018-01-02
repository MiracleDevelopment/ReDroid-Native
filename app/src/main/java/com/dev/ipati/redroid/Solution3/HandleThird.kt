package com.dev.ipati.redroid.Solution3

import android.arch.lifecycle.LiveData


class HandleThird {
    //Todo: Subscribe by LiveData to Main Class
    private val storeHandle by lazy {
        Store()
    }

    fun selectMsg(msg: String) : LiveData<String> {
        return when (msg) {
            msg -> {
                storeHandle.setMsg(msg)
                storeHandle
            }
            else -> {
                storeHandle.setMsg(msg)
                storeHandle
            }
        }
    }

    inner class Store : LiveData<String>() {
        private lateinit var message: String

        fun setMsg(msg: String) {
            message = msg
            value = msg
        }
    }
}