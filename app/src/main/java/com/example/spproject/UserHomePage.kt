package com.example.spproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserHomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_home_page)


        val sharedPreferences=getSharedPreferences("mySharedPreferencesProject", MODE_PRIVATE)
        val textViewShowName=findViewById<TextView>(R.id.showUserNameTextView)
        val logOutSharePrefrenceDataButton=findViewById<Button>(R.id.logOutSpDataButton)
        val Name=sharedPreferences.getString("Name",null)



        if (textViewShowName != null){
            textViewShowName.setText(Name)
        }

        logOutSharePrefrenceDataButton.setOnClickListener {
            val alertDialog=AlertDialog.Builder(this).create()
            val logOutLayout=LayoutInflater.from(this).inflate(R.layout.user_logout_aalert_dialog,null,false)
            val noLogOutButton=logOutLayout.findViewById<Button>(R.id.noLogOutButton)
            val yesLogOutButton=logOutLayout.findViewById<Button>(R.id.yesLogOutButton)
            yesLogOutButton.setOnClickListener {
                startActivity(Intent(this,MainActivity::class.java))
                alertDialog.dismiss()
            }
            noLogOutButton.setOnClickListener {
                Toast.makeText(this, "Dismiss", Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()
            }
            alertDialog.setView(logOutLayout)
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        
    }
}