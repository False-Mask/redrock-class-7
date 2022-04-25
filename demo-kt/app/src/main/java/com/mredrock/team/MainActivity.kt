package com.mredrock.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.mredrock.team.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observe()

        listener()


    }

    private fun listener() {
        binding.btnLoad.setOnClickListener {
            vm.renderIntent(MainIntent.ButtonClicked)
        }
    }


    private fun observe() {

        vm.state
            .onEach {
                renderState(it)
            }
            .launchIn(lifecycleScope)

        vm.event
            .onEach {
                renderEvent(it)
            }
            .launchIn(lifecycleScope)

    }


    private fun renderEvent(event: MainEvent) {

        when (event) {
            is MainEvent.Toast -> {
                Toast.makeText(this, event.text, Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun renderState(state: MainState) {
        when (state) {
            is MainState.Idle -> {
                binding.btnLoad.text = "点击加载"
                binding.tvContent.text = "Idle"
            }
            is MainState.Loading -> {
                binding.pbProgress.max = Int.MAX_VALUE
                binding.pbProgress.progress = (Int.MAX_VALUE * state.progress).toInt()
                Log.e("TAG", state.progress.toString())
                binding.tvContent.text = "Loading"
                binding.btnLoad.isEnabled = false
            }
            is MainState.Finished -> {
                binding.tvContent.text = "Finished"
                binding.btnLoad.isEnabled = true
                binding.btnLoad.text = "Finished"
            }
        }
    }
}