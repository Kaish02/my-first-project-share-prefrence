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

class UserRegister : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_register)

        val LoginPageTextView=findViewById<TextView>(R.id.textView2LoginPage)
        LoginPageTextView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        val nameEditText=findViewById<EditText>(R.id.nameRegEditText)
        val emailEditText=findViewById<EditText>(R.id.emailRegEditText)
        val passwordEditText=findViewById<EditText>(R.id.PasswordRegEditText)
        val rePasswordEditText=findViewById<EditText>(R.id.RePasswordRegEditText)
        val saveRegDataButton=findViewById<Button>(R.id.saveShowDataRegButton)


        saveRegDataButton.setOnClickListener {
            if (TextUtils.isEmpty(nameEditText.text.toString()) ||
                TextUtils.isEmpty(emailEditText.text.toString()) ||
                TextUtils.isEmpty(passwordEditText.text.toString()) ||
                TextUtils.isEmpty(rePasswordEditText.text.toString())) {
                Toast.makeText(this, "Please Enter Name and Email and Password", Toast.LENGTH_SHORT).show()
            }
            else if(passwordEditText.text.toString() != rePasswordEditText.text.toString()) {
                Toast.makeText(this, "Confome Password is Dos't Match", Toast.LENGTH_SHORT).show()
            }
            else
               {
                val editRegSharedPreferences = getSharedPreferences("mySharedPreferencesProject", MODE_PRIVATE).edit()
                editRegSharedPreferences.putString("Name", nameEditText.text.toString())
                editRegSharedPreferences.putString("Email", emailEditText.text.toString())
                editRegSharedPreferences.putString("Password", passwordEditText.text.toString())
                startActivity(Intent(this, UserHomePage::class.java))
                editRegSharedPreferences.apply()
            }
        }
    }
}