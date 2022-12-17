package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup


class MainActivity : AppCompatActivity() {
    enum class Operation {
        ADD, SUBTRACT, MULTIPLY
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val equals = findViewById<Button>(R.id.equals)
        val answer = findViewById<TextView>(R.id.answer)
        var operationType = Operation.ADD
        val operationGroup = findViewById<RadioGroup>(R.id.operation_group)
        operationGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.add_button -> {
                    operationType = Operation.ADD
                }
                R.id.subtract_button -> {
                    operationType = Operation.SUBTRACT
                }
                R.id.multiply_button -> {
                    operationType = Operation.MULTIPLY
                }
            }
        }

        equals.setOnClickListener {
            answer.text = performOperation(operationType, number1.text.toString(), number2.text.toString())
        }
    }

    private fun performOperation(op: Operation, number1: String, number2: String): String = when (op) {
        Operation.ADD -> add(number1, number2)
        Operation.SUBTRACT -> subtract(number1, number2)
        Operation.MULTIPLY -> multiply(number1, number2)
    }


    private fun add(number1: String, number2: String): String = (Integer.parseInt(number1) + Integer.parseInt(number2)).toString()

    private fun multiply(number1: String, number2: String): String = (Integer.parseInt(number1) * Integer.parseInt(number2)).toString()

    private fun subtract(number1: String, number2: String): String = (Integer.parseInt(number1) - Integer.parseInt(number2)).toString()


}