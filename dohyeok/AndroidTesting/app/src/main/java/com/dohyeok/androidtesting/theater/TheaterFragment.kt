package com.dohyeok.androidtesting.theater

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dohyeok.androidtesting.databinding.FragmentTheaterBinding


class TheaterFragment : Fragment() {
    private var _binding: FragmentTheaterBinding? = null
    private val binding get() = _binding!!

    private var isMonday = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTheaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    @SuppressLint("SetTextI18n")
    private fun initListener() {
        with(binding) {
            btnCheck.setOnClickListener {
                tvCheckResult.text = "티켓 가격은 ${TheaterUtil.ticketPrice(Integer.parseInt(etAge.text.toString()), isMonday)}$"
            }

            btnChangeWeek.setOnClickListener {
                tvWeek.text =
                    if (isMonday) "월요일 아님"
                    else "월요일"
                isMonday = !isMonday
            }
        }
    }

}