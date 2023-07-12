package com.example.myonboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.PagerAdapter

class OnboardingPagerAdapter(private val context: Context, private val onClickListener: View.OnClickListener) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)

        val layoutId = getLayoutId(position)
        val view = inflater.inflate(layoutId, container, false)

        container.addView(view)

        // Check if it's the last page and set the click listener for the "Start" button
        if (position == getCount() - 1) {
            val btnStart = view.findViewById<Button>(R.id.btnStart)
            btnStart.setOnClickListener(onClickListener)
        }

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    private fun getLayoutId(position: Int): Int {
        return when (position) {
            0 -> R.layout.onboarding_screen1
            1 -> R.layout.onboarding_screen2
            2 -> R.layout.onboarding_screen3
            else -> R.layout.onboarding_screen1
        }
    }
}


