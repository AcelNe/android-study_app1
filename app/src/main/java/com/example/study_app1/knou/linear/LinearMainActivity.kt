package com.example.study_app1.knou.linear

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study_app1.MainActivity
import com.example.study_app1.R
import com.example.study_app1.databinding.ActivityLinearMainBinding

class LinearMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityLinearMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.activity_linear_main)
        binding = ActivityLinearMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var intent: Intent
        //main으로 가는 버튼
        binding.btnGoMain.setOnClickListener {
            println("click Go Main BTN!!!!")
            intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }
        //linear2로 가는 버튼
        binding.submitBtn.setOnClickListener{
            println("click Submit Btn!!!!")
            intent = Intent(this, MainActivity::class.java)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}