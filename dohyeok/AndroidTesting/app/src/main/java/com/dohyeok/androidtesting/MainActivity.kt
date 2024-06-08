package com.dohyeok.androidtesting

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dohyeok.androidtesting.auction.AuctionFragment
import com.dohyeok.androidtesting.databinding.ActivityMainBinding
import com.dohyeok.androidtesting.profile.ProfileFragment
import com.dohyeok.androidtesting.theater.TheaterFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnGoTheater.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fcv_main, TheaterFragment()).commitNow()
            }
            btnGoAuction.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fcv_main, AuctionFragment()).commitNow()
            }
            btnGoProfile.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fcv_main, ProfileFragment()).commitNow()
            }
        }
    }

}