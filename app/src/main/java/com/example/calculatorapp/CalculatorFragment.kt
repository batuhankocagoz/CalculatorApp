package com.example.calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        binding.button0.setOnClickListener { appendVal("0", false) }
        binding.button1.setOnClickListener { appendVal("1", false) }
        binding.button2.setOnClickListener { appendVal("2", false) }
        binding.button3.setOnClickListener { appendVal("3", false) }
        binding.button4.setOnClickListener { appendVal("4", false) }
        binding.button5.setOnClickListener { appendVal("5", false) }
        binding.button6.setOnClickListener { appendVal("6", false) }
        binding.button7.setOnClickListener { appendVal("7", false) }
        binding.button8.setOnClickListener { appendVal("8", false) }
        binding.button9.setOnClickListener { appendVal("9", false) }

        binding.buttonDiv.setOnClickListener { appendVal("/", false) }
        binding.buttonMultiply.setOnClickListener { appendVal("*", false) }
        binding.buttonMinus.setOnClickListener { appendVal("-", false) }
        binding.buttonPlus.setOnClickListener { appendVal("+", false) }
        binding.buttonDot.setOnClickListener { appendVal(".", false) }
        binding.buttonClear.setOnClickListener { appendVal("", true) }

        binding.buttonEqual.setOnClickListener {

            val expression = ExpressionBuilder(binding.textView.text.toString()).build()
            val result = expression.evaluate()

            val resultText = result.toString()


            if (resultText.endsWith(".0")){
                val lastResult = resultText.split("\\.".toRegex()).toTypedArray()
                binding.textView.text = lastResult[0]
            }else{
                binding.textView.text = result.toString()
            }
        }
        return binding.root
    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            binding.textView.text = ""
        } else {
            binding.textView.append(string)
        }
    }
}