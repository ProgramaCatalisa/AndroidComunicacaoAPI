package br.com.zup.coffeeapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.coffeeapplication.data.model.CoffeeResponse
import br.com.zup.coffeeapplication.databinding.ActivityMainBinding
import br.com.zup.coffeeapplication.ui.viewmodel.CoffeeViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: CoffeeViewModel by lazy {
        ViewModelProvider(this)[CoffeeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getImageCoffee()
        intObserver()
    }

    private fun intObserver() {
        viewModel.coffeeResponse.observe(this) {
            loadImage(it)
        }
    }

    private fun loadImage(coffeeResponse: CoffeeResponse) {
        Picasso.get().load(coffeeResponse.arquivo)
            .into(binding.ivCoffee)
    }
}