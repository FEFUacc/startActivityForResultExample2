package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class NextActivity : AppCompatActivity() {
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val value = intent.getStringExtra(EXTRA_KEY)
        val emailInput = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val pwd1 = findViewById<EditText>(R.id.editTextTextPassword2)
        val pwd2 = findViewById<EditText>(R.id.editTextTextPassword3)
        emailInput.setText(value!!)
        findViewById<Button>(R.id.btn_reg).setOnClickListener {
            if (validate(emailInput, pwd1, pwd2)) {
                val res = emailInput.text.toString()
                val intent = Intent()
                intent.putExtra(MainActivity.EMAIL, res)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                validateAlert()
            }
        }
    }

    private fun validateAlert() {
        AlertDialog.Builder(this)
            .setTitle("Wrong email or password")
            .setMessage("Check your email and password")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(applicationContext, "OK is pressed", Toast.LENGTH_LONG).show()
            }
            .show()
    }
    private fun isValidString(str: String): Boolean{
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }

    private fun validate(email: EditText, pwd1: EditText, pwd2: EditText): Boolean {

        return pwd1.text.toString() == pwd2.text.toString() && isValidString(email.text.toString())
    }


    companion object {
        private const val EXTRA_KEY = "key"
        fun getIntent(context: Context, value: String): Intent {
            val intent = Intent(context, NextActivity::class.java)
            intent.putExtra(EXTRA_KEY, value)
            return intent
        }
    }
}