package com.example.daggermvvmapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvmapp.models.Product
import com.example.daggermvvmapp.retrofit.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiInterface: ApiInterface) {
    private val _product = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _product

    suspend fun getProducts() {
        val result = apiInterface.getProducts()
        if (result.isSuccessful && result.body() != null) {
            _product.postValue(result.body())
        }
    }
}