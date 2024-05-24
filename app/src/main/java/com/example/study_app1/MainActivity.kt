package com.example.study_app1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.study_app1.databinding.ActivityMainBinding
import com.example.study_app1.knou.LinearMainActivity
import com.example.study_app1.members.JoinActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        //suspend st run test
        lifecycleScope.launch {
            susFunc(10){
                println("mainAct.susfunc run()")
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val intent = Intent(this, JoinActivity::class.java)
        lateinit var intent: Intent
        binding.bntGoJoin.setOnClickListener{
            intent = Intent(this, JoinActivity::class.java)
            println("click go_join btn !!!!")
            startActivity(intent)
        }

        binding.btnGoLinear.setOnClickListener{
            intent = Intent(this, LinearMainActivity::class.java)
            println("click go_linear btn!!!!")
            startActivity(intent)
        }
    }

    fun mainBtnOnclick(view: View) {
        println("mainBtnOnclick fun run()!!!")

        val text2 = findViewById<TextView>(R.id.textView2)
        text2.setText("Change!!!")
        /*
        TextView text1 = (TextView) findViewById(R.id.textView);
        switch(view.getId()) {
            case R.id.button1: text2.setText("Change!!"); break;
            case R.id.button2: text2.setText("world"); break;
        }
        */

        val intent = Intent(this, SubActivity::class.java)
        startActivity(intent)
        /*Intent intent = new Intent(this, SubActivity.class);*/
    }
}

suspend fun susFunc(a:Int, callBack: () -> Unit={}){
    println("susFunc start() \na: $a")
    callBack()
    println("susFunc end()")
}