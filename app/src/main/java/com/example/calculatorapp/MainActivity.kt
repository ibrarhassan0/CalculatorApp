package com.example.calculatorapp

import android.media.VolumeShaper.Operation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)


        val viewModel=ViewModelProvider(this).get(CalculatorViewModel::class.java)
        viewModel.result.observe(this, Observer { stringResult-> result.setText(stringResult) })
        viewModel.newNumber.observe(this, Observer { stringnewNumber-> newNumber.setText(stringnewNumber) })
        viewModel.operation.observe(this, Observer { stringOperation-> operation.setText(stringOperation) })

        val listener = View.OnClickListener { v ->
           viewModel.digitpressed((v as Button).text.toString())
        }


        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            viewModel.operationlistener((v as Button).text.toString())

        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

        buttonNeg.setOnClickListener {
            viewModel.negpressed()

            }
        }}

