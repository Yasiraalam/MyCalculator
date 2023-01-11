package com.example.mycals

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.appcompat.widget.ButtonBarLayout
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewop =true
      var oldNumber = ""
      var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun numberCLick(view: View) {
        if(isNewop){
            result_tv.setText("")
        }
        isNewop =false
        var buclick = result_tv.text.toString()
        var buselect =view as MaterialButton
        when(buselect.id){
            button_1.id -> buclick += "1"
            button_2.id -> buclick += "2"
            button_3.id -> buclick += "3"
            button_4.id -> buclick += "4"
            button_5.id -> buclick += "5"
            button_6.id -> buclick += "6"
            button_7.id -> buclick += "7"
            button_8.id -> buclick += "8"
            button_9.id -> buclick += "9"
            button_0.id -> buclick += "0"
            button_dot.id -> buclick += "."

        }
        result_tv.setText(buclick.toString())
    }
    fun OperatorsEvent(view: View) {
        isNewop = true
        oldNumber = result_tv.text.toString()
        val Opselect :MaterialButton = view as MaterialButton
        when(Opselect.id){
            button_multiply.id -> {op ="×"}
            button_subtract.id -> {op ="-"}
            button_devide.id -> {op ="÷"}
            button_add.id -> {op ="+"}
        }
    }
    fun EqualBtn(view: View) {
        if(result_tv.text.toString()!="") {
            val NewNumber = result_tv.text.toString()
            var answer = 0.0
            when (op) {
                "+" -> answer = oldNumber.toDouble() + NewNumber.toDouble()
                "-" -> answer = oldNumber.toDouble() - NewNumber.toDouble()
                "÷" -> answer = oldNumber.toDouble() / NewNumber.toDouble()
                "×" -> answer = oldNumber.toDouble() * NewNumber.toDouble()
            }
            result_tv.setText(answer.toString())
        }
    }

    fun AcEvent(view: View) {
        result_tv.setText("")
    }

    fun backspace(view: View) {
        var Backspc:String?=null
        if(result_tv.text.length >0){
            val stringBuilder:StringBuilder = StringBuilder(result_tv.text)
            val find2 = result_tv.text.toString().last()
            stringBuilder.deleteCharAt(result_tv.text.length-1)
            Backspc = stringBuilder.toString()
            result_tv.setText(Backspc)
        }
    }
}





