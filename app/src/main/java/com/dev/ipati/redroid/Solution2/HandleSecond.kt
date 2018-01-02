package com.dev.ipati.redroid.Solution2


class HandleSecond {
    //Todo: Make save variable give other subscribe
    private val storeHandle: Store by lazy {
        Store()
    }

    fun selectMsgSolutionSecond(msg: String, callBack: (msg: String) -> Unit) {
        when (msg) {
            msg -> {
                storeHandle.setMsg(msg, {
                    callBack(storeHandle.storeMsg)
                })
            }

            else -> {
                storeHandle.setMsg(msg, {
                    callBack(storeHandle.storeMsg)
                })
            }
        }
    }

    inner class Store {
        lateinit var storeMsg: String
        fun setMsg(msg: String, storeSubscribe: (String) -> Unit) {
            storeMsg = msg
            storeSubscribe(storeMsg)
        }
    }
}