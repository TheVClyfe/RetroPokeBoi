package com.vclyfe.experiment.retrofitboi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.vclyfe.experiment.retrofitboi.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LifecycleTag", "onCreate2 called!")
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.secondActivityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("LifecycleTag", "onSaveInstanceState2 called!")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("LifecycleTag", "onRestoreInstanceState2 called!")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.d("LifecycleTag", "onCreateView2 called!")
        return super.onCreateView(name, context, attrs)
    }

    override fun onDestroy() {
        Log.d("LifecycleTag", "onDestroy2 called!")
        super.onDestroy()
    }

    override fun onStop() {
        Log.d("LifecycleTag", "onStop2 called!")
        super.onStop()
    }

    override fun onResume() {
        Log.d("LifecycleTag", "onResume2 called!")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifecycleTag", "onPause2 called!")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("LifecycleTag", "onRestart2 called!")
        super.onRestart()
    }

    override fun onStart() {
        Log.d("LifecycleTag", "onStart2 called!")
        super.onStart()
    }
}