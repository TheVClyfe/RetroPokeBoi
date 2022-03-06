package com.vclyfe.experiment.retrofitboi

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vclyfe.experiment.retrofitboi.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("HolderTag", "onCreate fragment called!")
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("HolderTag", "onSaveInstanceState fragment called!")
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d("HolderTag", "onCreateView fragment called!")
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("HolderTag", "onAttach fragment called!")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("HolderTag", "onDetach fragment called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HolderTag", "onPause fragment called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HolderTag", "onResume fragment called!")
    }

    override fun onStart() {
        super.onStart()
        Log.d("HolderTag", "onStart fragment called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HolderTag", "onStop fragment called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HolderTag", "onDestroy fragment called!")
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}