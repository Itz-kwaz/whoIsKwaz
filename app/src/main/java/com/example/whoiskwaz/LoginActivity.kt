package com.example.whoiskwaz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val registerLink: TextView = findViewById(R.id.register_link)
        registerLink.setOnClickListener {
            val registerIntent = Intent(this@LoginActivity,SignupActivity::class.java)
            startActivity(registerIntent)
        }

        val etName:EditText = findViewById(R.id.name_field)
        val etPassword:EditText = findViewById(R.id.password)
        val loginButton:Button = findViewById(R.id.button)

        loginButton.setOnClickListener{
            val user:String = etName.text.toString()
            val password: String = etPassword.text.toString()
            val prefs:SharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            var uName: String? = null
            var uPassword: String? = null
            if (prefs.contains("Name")){
              uName  = prefs.getString("Name", "").toString()
            }
            if (prefs.contains("password")){
              uPassword = prefs.getString("password", "").toString()
            }

            if (user.equals(uName) && password.equals(uPassword)){
                val editor:SharedPreferences.Editor = prefs.edit()
                editor.putString("display",uName)
                editor.apply()

                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext,"Incorrect password or username",Toast.LENGTH_LONG).show()
            }


        }

    }
}