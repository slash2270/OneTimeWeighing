package com.example.onetimeweighing

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val textView: TextView by lazy {
        findViewById(R.id.text)
    }

    private val button: Button by lazy {
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "有三個籃子 每顆球重10g 有一籃的球都是9g 只能秤一次 請問是哪一籃?"
        button.text = "答案"
        button.setOnClickListener {
            textView.text = getTarget(57, 10, 3).toString()
        }

    }

       /*
        * totalWeight = 每一籃照順序編號取出幾顆球的加總重量
        * oneStandardWeight = 每顆球的標準重量
        * quantity = 幾個籃子
        */

    private fun getTarget(totalWeight: Int, oneStandardWeight: Int, quantity: Int): Int {

        var maxWeight = 0

        for (i in 1 until quantity + 1) {
            maxWeight += i * oneStandardWeight
        }

        return maxWeight - totalWeight

    }

    /*
    我就不寫成code了,
    如果是要判斷多籃的話就是:
    假設有5籃 一樣是一顆球9g or 10g 一樣照編號取出顆數 第一籃取一顆...第五籃取五顆,
    總和假如是141g/15顆,
    9a+10b = 141
    a+b = 15
    所以答案不會只有一種,
    a = [1,3,5] || [4,5]
    b = [2,4] || [1,2,3]
    */

}