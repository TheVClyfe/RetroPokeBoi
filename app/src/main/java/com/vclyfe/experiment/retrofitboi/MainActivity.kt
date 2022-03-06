package com.vclyfe.experiment.retrofitboi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.vclyfe.experiment.retrofitboi.api.ApiServiceImpl
import com.vclyfe.experiment.retrofitboi.components.PokemonListAdapter
import com.vclyfe.experiment.retrofitboi.databinding.ActivityMainBinding
import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import com.vclyfe.experiment.retrofitboi.model.PokemonListData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var stringYolo: String

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var recyclerAdapter: PokemonListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LifecycleTag", "onCreate called!")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("LifecycleTag", "onSaveInstanceState called!")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("LifecycleTag", "onRestoreInstanceState called!")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.d("LifecycleTag", "onCreateView called!")
        return super.onCreateView(name, context, attrs)
    }

    override fun onDestroy() {
        Log.d("LifecycleTag", "onDestroy called!")
        super.onDestroy()
    }

    override fun onStop() {
        Log.d("LifecycleTag", "onStop called!")
        super.onStop()
    }

    override fun onResume() {
        Log.d("LifecycleTag", "onResume called!")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifecycleTag", "onPause called!")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("LifecycleTag", "onRestart called!")
        super.onRestart()
    }

    override fun onStart() {
        Log.d("LifecycleTag", "onStart called!")
        super.onStart()
    }

    private fun initView() {
        binding.searchView.setOnQueryTextListener(
            object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    //Toast.makeText(this@MainActivity, "You searched for $query!", Toast.LENGTH_SHORT).show()
                    query?.let {
                        ApiServiceImpl().getPokemonDetails(it)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({ response ->
                                    onSuccess(response)
                                },
                                { error ->
                                    onError(error)
                                }
                            )
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            }
        )

        binding.fab.setOnClickListener {
            ApiServiceImpl().getPokemonList(limit = binding.limit.text.toString(), offset = binding.offset.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    Toast.makeText(this, response.results.toString(), Toast.LENGTH_LONG).show()
                    showWithinRecyclerView(response.results)
                },
                    { error ->
                        onError(error)
                    }
                )

        }

        binding.nextFab.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        recyclerAdapter = PokemonListAdapter(this)
        binding.recyclerView.adapter = recyclerAdapter
    }

    private fun showWithinRecyclerView(results: List<PokemonListData>) {
        recyclerAdapter.addToPokemonList(results)
    }

    private fun onSuccess(response: PokemonDetailsModel) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show()
    }

    private fun onError(error: Throwable) {
        Toast.makeText(this, "$error - failed to get result!", Toast.LENGTH_LONG).show()
    }
}