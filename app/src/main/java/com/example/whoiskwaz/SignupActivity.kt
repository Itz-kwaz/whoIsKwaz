package com.example.whoiskwaz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val userName:EditText = findViewById(R.id.name_field)
        val userEmail:EditText = findViewById(R.id.email)
        val userPassword:EditText = findViewById(R.id.password)

        val signUpButton: Button = findViewById(R.id.button)
        signUpButton.setOnClickListener {
            val preferences:SharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val name:String = userName.text.toString()
            val newEmail:String = userEmail.text.toString()
            val newPassword:String = userPassword.text.toString()

            if(name.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty()){
                Toast.makeText(applicationContext,"Fill empty field",Toast.LENGTH_SHORT).show()
            }else {
                val editor:SharedPreferences.Editor = preferences.edit()
                editor.putString("Name",name)
                editor.putString("Email",newEmail)
                editor.putString("password",newPassword)
                editor.apply()

                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }
}
