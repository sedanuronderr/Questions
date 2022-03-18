package com.seda.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.seda.questions.databinding.ActivityMainBinding
import com.seda.questions.databinding.ActivityQuizzBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
binding.start.setOnClickListener {
    if(binding.name.text.toString().isEmpty()){
        Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()

    }else{
        val intent = Intent(this,QuizzActivity::class.java)

        intent.putExtra(Constants.USER_NAME,binding.name.text.toString())
        startActivity(intent)
        finish()
    }
}
    }

}