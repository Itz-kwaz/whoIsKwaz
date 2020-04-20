package com.example.whoiskwaz

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playStore: ImageView = findViewById(R.id.playStore)
        playStore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=my packagename ")
            startActivity(intent)
        }

        val website: ImageView = findViewById(R.id.website)
        website.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/Nkwachi "))
            startActivity(browserIntent)

        }

        val call: ImageView = findViewById(R.id.call)
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:08164180525")
            startActivity(intent)
        }

        val twitter: ImageView = findViewById(R.id.twitter)
        twitter.setOnClickListener {
            var intent: Intent
            try {
                this.packageManager.getPackageInfo("com.twitter.android", 0)
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=883478028474568705"))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/itz_kwaz"))
            }
            this.startActivity(intent)
        }

        val dribble: ImageView = findViewById(R.id.dribble)
        dribble.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dribbble.com/ "))
            startActivity(browserIntent)

        }

        val facebook: ImageView = findViewById(R.id.facebook)
        facebook.setOnClickListener {
            var intent: Intent = try {
                this.packageManager.getPackageInfo("com.facebook.katana", 0)
                Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"))
            } catch (e: Exception) {
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
            }
            startActivity(intent)

        }

        val skype: ImageView = findViewById(R.id.skype)
        skype.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.skype.com/"))
            startActivity(browserIntent)
        }

        val linkedn: ImageView = findViewById(R.id.linkedn)
        linkedn.setOnClickListener {
            var intent: Intent = try {
                this.packageManager.getPackageInfo("com.linkedin.android", 0)
                Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/nkwachi-nwamaghinna-0b937914b"))
            } catch (e: Exception) {
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/nkwachi-nwamaghinna-0b937914b/"))
            }
            startActivity(intent);
        }


        val email: ImageView = findViewById(R.id.mail)
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") //only email apps should handle this.
            intent.putExtra(Intent.EXTRA_EMAIL, "nkwachinwamaghinna@gmail.com")

        }

        val google: ImageView = findViewById(R.id.google)
        google.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/Nkwachi "))
            startActivity(browserIntent)
        }

        val github: ImageView = findViewById(R.id.github)
        github.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Itz-kwaz"))
            startActivity(browserIntent)
        }

        val instagram: ImageView = findViewById(R.id.instagram)
        instagram.setOnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/itz_kwaz")
            val igIntent = Intent(Intent.ACTION_VIEW, uri)

            igIntent.setPackage("com.instagram.android")
            try {
                startActivity(igIntent)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/itz_kwaz")
                    )
                )
            }
        }

    }

            override fun onRestart() {
                super.onRestart()
                Log.d(LOG_TAG, "On  Restart activity lifecycle")
            }

            override fun onPause() {
                super.onPause()
                Log.d(LOG_TAG, " On Pause activity lifecycle")
            }

            override fun onStart() {
                super.onStart()
                Log.d(LOG_TAG, "On Start activity lifecycle")
            }

            override fun onResume() {
                super.onResume()
                Log.d(LOG_TAG, "The activity lifecycle is onResume state")
            }

            override fun onStop() {
                super.onStop()
                Log.d(LOG_TAG, "The activity lifecycle is onStop state")

            }
        }



