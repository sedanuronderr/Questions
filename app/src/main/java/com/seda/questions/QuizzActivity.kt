package com.seda.questions

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.seda.questions.databinding.ActivityQuizzBinding

class QuizzActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityQuizzBinding
    private var mCurrentPosition:Int=1
    private var mQuestionList :ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)
mQuestionList = Constants.getQuestions()
setQuestion()

       binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
    }


    private  fun setQuestion(){
        mCurrentPosition =1
        val question = mQuestionList?.get(mCurrentPosition-1)

      defaultOptions()
        binding.progressbar.progress=mCurrentPosition
        binding.textProgressbar.text="$mCurrentPosition" + "/" + binding.progressbar.max

        binding.question.text = question!!.question
        binding.image.setImageResource(question.image)
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text= question.optionFour
    }

    private fun defaultOptions(){
        val options = ArrayList<TextView>()
        options.add(0,binding.optionOne)
        options.add(1,binding.optionTwo)
        options.add(2,binding.optionThree)
        options.add(3,binding.optionFour)

        for(option in options){
            option.setTextColor(Color.GRAY)
            option.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        }
    }

    override fun onClick(v: View?) {

    }
}