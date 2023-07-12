package com.example.myonboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var btnSkip: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        btnSkip = findViewById(R.id.btnSkip)

        val adapter = OnboardingPagerAdapter(this, View.OnClickListener {
            // Handle "Start" button click event
            navigateToHomeActivity()
        })
        viewPager.adapter = adapter

        btnSkip.setOnClickListener {
            navigateToHomeActivity()
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Not needed for this example
            }

            override fun onPageSelected(position: Int) {
                // Handle page selection change
                if (position == adapter.count - 1) {
                    // Last page reached, show a different text on the skip button
                    btnSkip.setText(R.string.skip_intro)
                } else {
                    // Reset the skip button text
                    btnSkip.setText(R.string.skip_intro)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Not needed for this example
            }
        })
    }


    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
