package com.dohyeok.androidtesting.theater

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dohyeok.androidtesting.databinding.FragmentTheaterBinding
import kotlinx.coroutines.launch


class TheaterFragment : Fragment() {
    private var _binding: FragmentTheaterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TheaterViewModel by viewModels()
    private var isMonday = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTheaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
        initObserver()
    }

    @SuppressLint("SetTextI18n")
    private fun initListener() {
        with(binding) {
            btnCheck.setOnClickListener {
                tvCheckResult.text = "티켓 가격은 ${TheaterUtil.ticketPrice(Integer.parseInt(etAge.text.toString()), isMonday)}$"
            }

            btnChangeWeek.setOnClickListener {
                viewModel.changeDayOfWeek()
            }
        }
    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.isMonday.observe(viewLifecycleOwner) { isMonday ->
                        binding.tvWeek.text = if(isMonday) "월요일" else "월요일 아님"
                    }
                }
            }
        }
    }
}