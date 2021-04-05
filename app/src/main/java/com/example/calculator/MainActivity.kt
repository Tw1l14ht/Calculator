package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var etNum1: EditText? = null
    var etNum2: EditText? = null
    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMult: Button? = null
    var btnDiv: Button? = null
    var tvResult: TextView? = null
    var oper = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNum1 = findViewById<View>(R.id.etNum1) as EditText
        etNum2 = findViewById<View>(R.id.etNum2) as EditText
        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        btnSub = findViewById<View>(R.id.btnSub) as Button
        btnMult = findViewById<View>(R.id.btnMult) as Button
        btnDiv = findViewById<View>(R.id.btnDiv) as Button
        tvResult = findViewById<View>(R.id.tvResult) as TextView

        btnAdd!!.setOnClickListener(this)
        btnSub!!.setOnClickListener(this)
        btnMult!!.setOnClickListener(this)
        btnDiv!!.setOnClickListener(this)
}
    override fun onClick(v: View?) {
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        if (TextUtils.isEmpty(etNum1!!.text.toString()) || (TextUtils.isEmpty(etNum2!!.text.toString())))
            return

        num1 = etNum1!!.text.toString().toFloat()
        num2 = etNum2!!.text.toString().toFloat()
        when (v!!.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
            }
            else -> {
            }
        }
        tvResult!!.text = "$num1 $oper $num2 = $result"
    }

}