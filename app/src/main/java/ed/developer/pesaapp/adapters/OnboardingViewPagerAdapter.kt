package ed.developer.pesaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import ed.developer.pesaapp.R
import ed.developer.pesaapp.data.OnboardingData

//
// Created by Eddy Developer W. on 11/26/2020.
// Copyright (c) 2020 Eddy Developer's Team Inc. All rights reserved.
//adapter for onboarding page
class OnboardingViewPagerAdapter(val pagers: ArrayList<OnboardingData>) :
    RecyclerView.Adapter<OnboardingViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(v: View) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.onboarding_pagers, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val page = pagers[position]
        holder.itemView.findViewById<TextView>(R.id.text_lottie_description).text = page.description
        holder.itemView.findViewById<TextView>(R.id.text_lottie_title).text = page.title
        holder.itemView.findViewById<LottieAnimationView>(R.id.lottie_onboarding)
            .setAnimation(page.lottieAnimation)

    }

    override fun getItemCount(): Int {
        return pagers.size
    }
}