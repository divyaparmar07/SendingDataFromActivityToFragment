package com.example.sendingdatafromactivitytofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var eWeight : EditText
    lateinit var eHeight : EditText
    lateinit var calculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eWeight = findViewById(R.id.editTextWeight)
        eHeight = findViewById(R.id.editTextHeight)
        calculate = findViewById(R.id.buttonCalculate)

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        val bmiFragment = BMIFragment()

        calculate.setOnClickListener {
            val weight = eWeight.text.toString().toInt()
            val height = eHeight.text.toString().toInt()

            val bundle = Bundle()
            bundle.putInt("weight",weight)
            bundle.putInt("height",height)

            bmiFragment.arguments = bundle

            ft.add(R.id.frame,bmiFragment)

            ft.commit()
        }
    }
}