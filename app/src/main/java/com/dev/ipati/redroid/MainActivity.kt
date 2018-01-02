package com.dev.ipati.redroid

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.dev.ipati.redroid.Solution1.HandleFirst
import com.dev.ipati.redroid.Solution2.HandleSecond
import com.dev.ipati.redroid.Solution3.HandleThird
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val handleSolutionFirst: HandleFirst by lazy {
        HandleFirst()
    }

    private val handleSolutionSecond: HandleSecond by lazy {
        HandleSecond()
    }

    private val handleSolutionThird: HandleThird by lazy {
        HandleThird()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btHandleFirst.setOnClickListener(this)
        btHandleSecond.setOnClickListener(this)
        btHandleThird.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btHandleFirst -> {
                handleSolutionFirst.selectMsgSolution2("สวัสดีตอนเช้าครับ อิอิ...", {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    Log.d("SolutionFirst", it)
                })
            }

            R.id.btHandleSecond -> {
                handleSolutionSecond.selectMsgSolutionSecond("อย่าลืมกินข้าวเที่ยงนะครับ เดี๋ยวทำงานไม่ไหว", {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    Log.d("SolutionSecond", it)
                })
            }

            R.id.btHandleThird -> {
                handleSolutionThird.selectMsg("ขอบคุณที่เข้ามาดูนะครับ").observe(this, Observer<String> {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    Log.d("SolutionThird", it)
                })
            }
        }
    }
}
