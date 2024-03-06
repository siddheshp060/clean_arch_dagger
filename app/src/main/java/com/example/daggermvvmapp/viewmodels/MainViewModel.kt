package com.example.daggermvvmapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvmapp.models.Product
import com.example.daggermvvmapp.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(val repository: ProductRepository) : ViewModel() {
    val productsListData: LiveData<List<Product>>
        get() = repository.productList

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}