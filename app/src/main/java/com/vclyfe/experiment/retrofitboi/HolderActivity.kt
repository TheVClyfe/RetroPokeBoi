package com.vclyfe.experiment.retrofitboi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.fragment.app.commit
import com.vclyfe.experiment.retrofitboi.databinding.ActivityHolderBinding

class HolderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("HolderTag", "onCreate Holder called!")
        binding = ActivityHolderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.commit {
            add(binding.fragmentContainer.id, FirstFragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("HolderTag", "onSaveInstanceState Holder called!")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("HolderTag", "onRestoreInstanceState Holder called!")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.d("HolderTag", "onCreateView Holder called!")
        return super.onCreateView(name, context, attrs)
    }

    override fun onDestroy() {
        Log.d("HolderTag", "onDestroy Holder called!")
        super.onDestroy()
    }

    override fun onStop() {
        Log.d("HolderTag", "onStop Holder called!")
        super.onStop()
    }

    override fun onResume() {
        Log.d("HolderTag", "onResume Holder called!")
        super.onResume()
    }

    override fun onPause() {
        Log.d("HolderTag", "onPause Holder called!")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("HolderTag", "onRestart Holder called!")
        super.onRestart()
    }

    override fun onStart() {
        Log.d("HolderTag", "onStart Holder called!")
        super.onStart()
    }
}