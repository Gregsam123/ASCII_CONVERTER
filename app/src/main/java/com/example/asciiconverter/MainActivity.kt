package com.example.asciiconverter

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encodeBtn.setOnClickListener()
        {
            encode()
        }

        decodeBtn.setOnClickListener()
        {
            decode()
        }
    }

    private fun encode()
    {
        val txt = textToConvert.text.toString()
        val binary = AsciiConverter.stringToBinary(txt)
        resultTv.text = binary
        hideKeyboard()
    }

    private fun decode()
    {
        val binary = textToConvert.text.toString()
        val txt = AsciiConverter.binaryToString(binary)
        resultTv.text = txt
        hideKeyboard()
    }

    private fun hideKeyboard()
    {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus

        if (view == null)
            view = View(this)

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
