package com.seda.questions
 object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(1,"What country does this flag belong to?",
        R.drawable.france,"Argentina","German","France",
            "Turkey",3)
        questionList.add(que1)


        val que2 = Question(2,"What country does this flag belong to?",
            R.drawable.german,"Argentina","German","France",
            "Turkey",2)
        questionList.add(que2)

        val que3 = Question(3,"What country does this flag belong to?",
            R.drawable.urguay,"Argentina","German","France",
            "Urguay",4)
        questionList.add(que3)

        val que4 = Question(4,"What country does this flag belong to?",
            R.drawable.vietnam,"Vietnam","German","France",
            "Urguay",1)
        questionList.add(que4)
        return  questionList
    }
}