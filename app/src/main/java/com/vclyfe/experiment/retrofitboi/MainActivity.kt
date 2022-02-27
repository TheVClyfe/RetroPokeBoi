package com.vclyfe.experiment.retrofitboi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.vclyfe.experiment.retrofitboi.api.ApiServiceImpl
import com.vclyfe.experiment.retrofitboi.databinding.ActivityMainBinding
import com.vclyfe.experiment.retrofitboi.model.PokemonDetailsModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
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
                },
                    { error ->
                        onError(error)
                    }
                )
        }
    }

    private fun onSuccess(response: PokemonDetailsModel) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show()
    }

    private fun onError(error: Throwable) {
        Toast.makeText(this, "$error - failed to get result!", Toast.LENGTH_LONG).show()
    }
}