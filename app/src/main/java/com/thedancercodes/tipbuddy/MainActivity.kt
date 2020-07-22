package com.thedancercodes.tipbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        // Set initial SeekBar and TextView Tip value when you initialize the app.
        tipSeekBar.progress = INITIAL_TIP_PERCENT
        tvTipPercent.text = "$INITIAL_TIP_PERCENT%"

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

        // 6. Add a listener for when we update the base value edit text
        baseEditText.addTextChangedListener(object: TextWatcher {

            // Called after the user has changed some text
            override fun afterTextChanged(editable: Editable?) {

                // Log statement to verify the functionality of this method.
                // Log the method name and the value (What the user has been typing).
                Log.i(TAG, "afterTextChanged $editable")

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        })
    }
}