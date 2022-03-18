package com.seda.questions

import android.annotation.SuppressLint
import android.content.Intent

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.seda.questions.databinding.ActivityQuizzBinding

class QuizzActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityQuizzBinding
    private var mCurrentPosition:Int=1
    private var mQuestionList :ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswer:Int=0
    private  var mUserName:String?= null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
   mQuestionList = Constants.getQuestions()
setQuestion()

       binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.submit.setOnClickListener(this)
    }


    @SuppressLint("SetTextI18n")
    private  fun setQuestion(){
        val question = mQuestionList?.get(mCurrentPosition-1)
        defaultOptions()

        if(mCurrentPosition == mQuestionList!!.size){
            binding.submit.text="Finish"
        }else{
            binding.submit.text = "Submit"
        }

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
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        }
    }

    override fun onClick(v: View?) {
 when(v?.id){
     R.id.option_one ->{
         selectedOptionView(binding.optionOne,1)
     Log.e("bastı","1")
     }
     R.id.option_two ->{
         selectedOptionView(binding.optionTwo,2)
         Log.e("bastı","2")
     }
     R.id.option_three ->{
         selectedOptionView(binding.optionThree,3)
         Log.e("bastı","3")
     }
     R.id.option_four ->{
         selectedOptionView(binding.optionFour,4)
         Log.e("bastı","4")
     }
     R.id.submit ->{
  if(mSelectedOptionPosition ==0){
       mCurrentPosition++

      when{
          mCurrentPosition <= mQuestionList!!.size   ->{
              setQuestion()
          } else ->{
                    val intent =Intent(this,ResultActivity::class.java)
          intent.putExtra(Constants.USER_NAME,mUserName)
          intent.putExtra(Constants.Correct_Answers,mCorrectAnswer)
          intent.putExtra(Constants.Total_Question,mQuestionList!!.size)
                  startActivity(intent)
finish()
          }
      }

  }else{

      val question = mQuestionList?.get(mCurrentPosition-1)

      if(question!!.correctAnswer != mSelectedOptionPosition) {

             answerView(mSelectedOptionPosition,R.drawable.wrong)
          answerView(question.correctAnswer,R.drawable.correct)
          if(mCurrentPosition == mQuestionList!!.size){
              binding.submit.text ="FINISH"
          }
          else{

              binding.submit.text ="go to next question"
          }
          mSelectedOptionPosition =0

      }else{
          mCorrectAnswer++
          answerView(question.correctAnswer,R.drawable.correct)

          if(mCurrentPosition == mQuestionList!!.size){
              binding.submit.text ="FINISH"
          }
          else{

              binding.submit.text ="go to next question"
          }
          mSelectedOptionPosition =0
      }


  }

     }
 }
    }
    private fun answerView(answer:Int,drawableView:Int){
   when(answer){
       1->{
           binding.optionOne.background=ContextCompat.getDrawable(this,drawableView)

       }
       2->{
           binding.optionTwo.background=ContextCompat.getDrawable(this,drawableView)
       }
       3->{
           binding.optionThree.background=ContextCompat.getDrawable(this,drawableView)
       }
       4->{
           binding.optionFour.background=ContextCompat.getDrawable(this,drawableView)
       }

   }

    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptions()
        mSelectedOptionPosition = selectedOptionNum
        Log.e("num","${mSelectedOptionPosition}")
        Log.e("text","${tv}")
        if(mSelectedOptionPosition == 1) {
            tv.setTextColor(Color.DKGRAY)
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.select_option)
        }
       if(mSelectedOptionPosition == 2) {
            tv.setTextColor(Color.DKGRAY)
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.select_option)
        }
       if(mSelectedOptionPosition == 3) {
            tv.setTextColor(Color.DKGRAY)
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.select_option)
        }
       if(mSelectedOptionPosition == 4) {
            tv.setTextColor(Color.DKGRAY)
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.select_option)
        }
        }
}