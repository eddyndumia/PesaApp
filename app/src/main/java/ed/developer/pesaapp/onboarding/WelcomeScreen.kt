package ed.developer.pesaapp.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import ed.developer.pesaapp.R
import ed.developer.pesaapp.adapters.OnboardingViewPagerAdapter
import ed.developer.pesaapp.data.OnboardingData
import ed.developer.pesaapp.user.Login
import ed.developer.pesaapp.user.Register
import kotlinx.android.synthetic.main.activity_welcome_screen.*

//
// Created by Eddy Developer W. on 11/25/2020.
// Copyright (c) 2020 Eddy Developer's Team Inc. All rights reserved.
//
class WelcomeScreen : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var registerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
//        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
//                // Set the content to appear under the system bars so that the
//                // content doesn't resize when the system bars hide and show.
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                // Hide the nav bar and status bar
//                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_FULLSCREEN)

        val pagers = ArrayList<OnboardingData>()
        pagers.add(
            OnboardingData(
                "Watch Ads for Cash $$",
                "Watch 30s ads on PesaApp and collect cash rewards up to KSH.20,000.",
                R.raw.duckie
            )
        )
        pagers.add(
            OnboardingData(
                "Direct Payment",
                "Receive payment direct to your mobile with no delays!.",
                R.raw.payment
            )
        )
        pagers.add(
            OnboardingData(
                "Refer and Earn",
                "Refer your friends and earn some extra Ksh into your account!.",
                R.raw.social_media
            )
        )
        pagers.add(
            OnboardingData(
                "Redeem Rewards!",
                "Redeem up to Ksh.3,000 worth of cash and Safaricom Airtime!",
                R.raw.redeem
            )
        )
        pagers.add(
            OnboardingData(
                "Kuomoka ni leo!",
                "Don't miss out on a chance to get extra cash for yourself!",
                R.raw.richy
            )
        )
        val viewpager = findViewById<ViewPager2>(R.id.viewpager_onboarding)
        val adapter = OnboardingViewPagerAdapter(pagers)
        viewpager.adapter = adapter
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        dotsindicator_Onboarding.setViewPager2(viewpager)

        //init
        loginButton = findViewById(R.id.button_login)
        registerButton = findViewById(R.id.button_register)

        loginButton.setOnClickListener {
            loginActivity()
        }
        registerButton.setOnClickListener {
            registerActivity()
        }

    }

    private fun registerActivity() {
        val intentRegister = Intent(this@WelcomeScreen, Register::class.java)
        startActivity(intentRegister)
    }

    private fun loginActivity() {
        val loginActivity = Intent(this@WelcomeScreen, Login::class.java)
        startActivity(loginActivity)
    }
}