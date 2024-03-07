package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.google.android.material.textfield.TextInputEditText
import java.sql.Struct

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val value = intent.getStringExtra(EXTRA_KEY)
        val tinput = findViewById<TextInputEditText>(R.id.text_input_edit_text)
        tinput.setText(value!!)


        findViewById<Button>(R.id.btn_save).setOnClickListener {
            val res = tinput.text.toString()
            val intent = Intent()
            intent.putExtra("!!!", res)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }



    companion object {
        private const val EXTRA_KEY = "key"


        fun getIntent(context: Context, value: String) : Intent {
            val intent = Intent(context, NextActivity::class.java)
            intent.putExtra(EXTRA_KEY, value)
            return intent
        }
    }
}