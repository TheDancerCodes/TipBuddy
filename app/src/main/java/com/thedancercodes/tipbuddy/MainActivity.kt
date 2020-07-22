package com.thedancercodes.tipbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

// Constants
private const val TAG = "MainActivity"
private const val INITIAL_TIP_PERCENT = 15

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Notifies you that the user has changed the SeekBar
        tipSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {

                // 2. Print out the int value of progress that is coming through.
                Log.i(TAG, "onProgressChanged $progress")

                // 3. Update value of the tip as we interact with the SeekBar
                // Kotlin - replace this with the actual integer progress and append %
                // Convert the progress value to a string and concatenate a % symbol after the value
                tvTipPercent.text = "$progress%"

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}