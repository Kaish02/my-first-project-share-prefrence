package com.example.spproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val registerPageTextView = findViewById<TextView>(R.id.textView2RegisterPage)
        registerPageTextView.setOnClickListener {
            startActivity(Intent(this, UserRegister::class.java))
        }


        val userNameEditText = findViewById<EditText>(R.id.UserNameEditText)
        val userPasswordEditText = findViewById<EditText>(R.id.UserPasswordEditText)
        val saveDataSharePrefrenceButton = findViewById<Button>(R.id.saveDataLoginSharePrefrenceButton)


        saveDataSharePrefrenceButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("mySharedPreferencesProject", MODE_PRIVATE)

            val reName= sharedPreferences.getString("Email",null)
            val rePassword=sharedPreferences.getString("Password", null)

            val inputName=userNameEditText.text.toString()
            val inputPassword=userPasswordEditText.text.toString()

            if (TextUtils.isEmpty(userNameEditText.text.toString()) || TextUtils.isEmpty(userPasswordEditText.text.toString())) {
                Toast.makeText(this@MainActivity, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            }
            else if( inputName != reName ||  inputPassword != rePassword){
                Toast.makeText(this, "Don't Match", Toast.LENGTH_SHORT).show()
            }
            else {
                val editor = getSharedPreferences("mySharedPreferencesProject", MODE_PRIVATE).edit()
                editor.putString("userName", userNameEditText.text.toString())
                editor.putString("userPassword", userPasswordEditText.text.toString())
                startActivity(Intent(this,UserHomePage::class.java))
                editor.apply()
                finish()
            }
        }
    }

}