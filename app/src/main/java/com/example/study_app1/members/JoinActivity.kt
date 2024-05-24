package com.example.study_app1.members

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study_app1.MainActivity
import com.example.study_app1.R
import com.example.study_app1.databinding.ActivityJoinBinding
import com.example.study_app1.databinding.ActivityMainBinding

class JoinActivity : AppCompatActivity() {
    val binding by lazy { ActivityJoinBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = Intent(this, MainActivity::class.java)
        //btn
        //join
        binding.joinBtnJoin.setOnClickListener{
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }

        //login
        binding.joinBtnLogin.setOnClickListener{
            println("join btn_join onclick run()!!!")
            var id = binding.joinId.text
            var pw = binding.joinPw.text
            println("ID: $id |::| PW: $pw")

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }
    }
}