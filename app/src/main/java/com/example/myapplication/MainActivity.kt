package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data?.getStringExtra(EMAIL)
            findViewById<EditText>(R.id.editTextTextEmailAddress).setText(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.regbtn).setOnClickListener{
            launcher.launch(NextActivity.getIntent(this, findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString() ))
        }
    }

    companion object{
        const val EMAIL = "email"
    }
}