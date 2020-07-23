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
        tipSeekBar.progress = INITIAL_TIP_PERCENT
        tvTipPercent.text = "$INITIAL_TIP_PERCENT%"

        tvTipAmount.text = "$INITIAL_EMPTY_VALUE"
        tvTotalAmount.text = "$INITIAL_EMPTY_VALUE"

        // 1. Notifies you that the user has changed the SeekBar
        tipSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {

                // 2. Print out the int value of progress that is coming through.
                Log.i(TAG, "onProgressChanged $progress")

                // 3. Update value of the tip as we interact with the SeekBar
                // Kotlin - replace this with the actual integer progress and append %
                // Convert the progress value to a string and concatenate a % symbol after the value
                tvTipPercent.text = "$progress%"

                // 9. Call method for SeekBar functionality to work
                        computeTipAndTotal()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        // 6. Add a listener for when we update the bill value edit text
        billEditText.addTextChangedListener(object : TextWatcher {

            // Called after the user has changed some text
            override fun afterTextChanged(editable: Editable?) {

                // Log statement to verify the functionality of this method.
                // Log the method name and the value (What the user has been typing).
                Log.i(TAG, "afterTextChanged $editable")

                computeTipAndTotal()

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        })
    }


    // 7. Everytime the bill amount changes, we want to calculate the tip and total values.
    fun computeTipAndTotal() {

        // 10 - Conditional check to fix java.lang.NumberFormatException: empty String crash,
        // when edit text is empty.
        if (billEditText.text.isEmpty()) {

            // 10b) Update values of tip and total to empty & return here
            tvTipAmount.text = "$INITIAL_EMPTY_VALUE"
            tvTotalAmount.text = "$INITIAL_EMPTY_VALUE"
            return // This ensures the logic in 7b isn't run. 👍
        }

        //7b) Get the value of the bill and tip percent
        // Once we have these values, we can calculate the amount for the tip, (tip% x bill)
        // We can also calculate the value for the total (tip + bill)
        // Bill value - value inside edit text
        // Call to string to change int to string. toDouble so that we can do math.
        val billAmount = billEditText.text.toString().toDouble()

        // Tip %age - The progress of the SeekBar
        val tipPercent = tipSeekBar.progress

        // Calculate the tip amount
        val tipAmount = billAmount * tipPercent / 100

        // Calculate total amount
        val totalAmount = billAmount + tipAmount

        // 8) NOTE: After the calculation, place the tipAmount and totalAmount, into
        // the respective textViews.
        tvTipAmount.text = "%.2f".format(tipAmount)
        tvTotalAmount.text = "%.2f".format(totalAmount)
    }
}