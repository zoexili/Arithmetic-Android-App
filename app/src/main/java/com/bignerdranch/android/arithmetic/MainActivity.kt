package com.bignerdranch.android.arithmetic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.bignerdranch.android.arithmetic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var res: Double = 0.0
    private var check : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_add -> {
                    check = -1
                    res = binding.operand1.getText().toString().toDouble() + binding.operand2.getText().toString().toDouble()
                }

                R.id.radio_minus -> {
                    check = -1
                    res = binding.operand1.getText().toString().toDouble() - binding.operand2.getText().toString().toDouble()
                }

                R.id.radio_multiply -> {
                    check = -1
                    res = binding.operand1.getText().toString().toDouble() * binding.operand2.getText().toString().toDouble()
                }

                R.id.radio_divide -> {
                    check = 1
                    res = binding.operand1.getText().toString().toDouble() / binding.operand2.getText().toString().toDouble()
                }

                R.id.radio_modulo -> {
                    check = 1
                    res = binding.operand1.getText().toString().toDouble() % binding.operand2.getText().toString().toDouble()
                }
            }
        }

        binding.calculateButton.setOnClickListener { view: View ->
            if(binding.operand2.getText().toString().toDouble() == 0.0 && check == 1) {
                binding.result.text = "Not Defined"
                Toast.makeText(
                    this,
                    R.string.divide0_toast,
                    Toast.LENGTH_LONG
                ).show()
            }
            else {
                binding.result.text = res.toString()
            }
        }
    }
}