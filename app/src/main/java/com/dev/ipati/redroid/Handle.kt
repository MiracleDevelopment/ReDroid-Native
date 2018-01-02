package com.dev.ipati.redroid

import android.arch.lifecycle.LiveData


class Handle(private val msg: String) {
    private val storeHandle by lazy {
        Store()
    }

    private val observeHandle by lazy {
        ObserveValue()
    }

    init {
        calculateMsg(msg)
    }

    private fun calculateMsg(msg: String) {
        when (msg) {
            "" -> {
                storeHandle.setMsg("")
            }
            else -> {
                storeHandle.setMsg("")
            }
        }
    }


    inner class Store {
        private lateinit var msg: String

        fun setMsg(newMsg: String) {
            msg = newMsg
            observeHandle.setMsg(newMsg)
        }
    }

    inner class ObserveValue : LiveData<String>() {
        init {
            getMsg()
        }

        private fun getMsg() {
            value  = msg
        }

        fun setMsg(newMsg : String){
            value = newMsg
        }
    }
}

