package com.rosy.loctraceapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.rosy.loctraceapplication.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = this.findViewById<Button>(R.id.button)
        btn1.setOnClickListener {
            //TODO Auto-generated method stub
            setTitle("button1 被用户点击了");
            Log.i("widgetDemo", "button1 被用户点击了。");
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }
}