package com.example.study_app1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)



        //suspend st run test
//        lifecycleScope.launch {
//            susFunc(10){
//                println("mainAct.susfunc run()")
//            }
//        }
    }
}

//suspend fun susFunc(a:Int, callBack: () -> Unit={}){
//    println("susFunc start() \na: $a")
//    callBack()
//    println("susFunc end()")
//}