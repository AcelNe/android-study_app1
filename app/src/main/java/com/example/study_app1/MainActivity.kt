package com.example.study_app1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.study_app1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
/*
        //suspend st run test
        lifecycleScope.launch {
            susFunc(10){
                println("mainAct.susfunc run()")
            }
        }*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = Intent(this, JoinActivity::class.java)
        binding.btnNext.setOnClickListener {
            println("click next button!!")
            startActivity(intent)
        }
    }
}

suspend fun susFunc(a:Int, callBack: () -> Unit={}){
    println("susFunc start() \na: $a")
    callBack()
    println("susFunc end()")
}