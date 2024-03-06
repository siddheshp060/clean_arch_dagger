package com.example.daggermvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.MyApplication
import com.example.daggermvvmapp.viewmodels.MainViewModel
import com.example.daggermvvmapp.viewmodels.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val textView = findViewById<TextView>(R.id.textView)

        mainViewModel.productsListData.observe(this){ it ->
            textView.text = it.joinToString { it.title + "\n\n"}
        }

    }
}