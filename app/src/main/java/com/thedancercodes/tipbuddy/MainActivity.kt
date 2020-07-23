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
private const val INITIAL_EMPTY_VALUE = 0.00

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial SeekBar and TextView Tip value when you initialize the app.
        // TODO - Uncomment this code before you start implementing the SeekBar functionality
//        tipSeekBar.progress = INITIAL_TIP_PERCENT
//        tvTipPercent.text = "$INITIAL_TIP_PERCENT%"
//
//        tvTipAmount.text = "$INITIAL_EMPTY_VALUE"
//        tvTotalAmount.text = "$INITIAL_EMPTY_VALUE"

        // TODO Add SeekBar.setOnSeekBarChangeListener() - Notifies you that the user has changed the SeekBar


        // TODO Add EditText.addTextChangedListener() - a listener for when we update the bill value edit text
    }

    // TODO Add computeTipAndTotal - Everytime the bill amount changes, we want to calculate the tip and total values.
}