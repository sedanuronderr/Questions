package com.seda.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seda.questions.databinding.ActivityQuizzBinding
import com.seda.questions.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(Constants.USER_NAME)
        binding.username.text = username
        val totalquestion = intent.getIntExtra(Constants.Total_Question,0)
        val correct = intent.getIntExtra(Constants.Correct_Answers,0)

          binding.score.text= "Your Score is $correct out of $totalquestion"
binding.finish.setOnClickListener{
    startActivity(Intent(this,MainActivity::class.java))
    finish()
}
    }
}