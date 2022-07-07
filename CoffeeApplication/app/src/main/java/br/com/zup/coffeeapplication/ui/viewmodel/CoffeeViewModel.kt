package br.com.zup.coffeeapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.coffeeapplication.data.RetrofitService
import br.com.zup.coffeeapplication.data.model.CoffeeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoffeeViewModel : ViewModel() {
    private val _coffeeResponse = MutableLiveData<CoffeeResponse>()
    val coffeeResponse: LiveData<CoffeeResponse> = _coffeeResponse

    fun getImageCoffee() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitService.apiService.getImageCoffee()
                }
                _coffeeResponse.value = response
            } catch (ex: Exception) {
                Log.i("Error", "Error ----- > ${ex.message}")
            }
        }
    }
}