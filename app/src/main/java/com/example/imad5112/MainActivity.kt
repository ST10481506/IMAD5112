package com.example.imad5112

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding all views
        val textInput = findViewById<EditText>(R.id.timeInput)
        val buttonShow = findViewById<Button>(R.id.submitButton)
        val buttonReset = findViewById<Button>(R.id.resetButton)
        val outputText = findViewById<TextView>(R.id.suggestionOutput)

        buttonShow.setOnClickListener {
            val userTyped = textInput.text.toString().trim()

            // Empty check
            if (userTyped == "") {
                textInput.error = "Please type something!"
                outputText.text = ""
                return@setOnClickListener
            }


            if (userTyped.lowercase() != "morning" &&
                userTyped.lowercase() != "mid-morning" &&
                userTyped.lowercase() != "afternoon-lunch" &&
                userTyped.lowercase() != "afternoon-snack" &&
                userTyped.lowercase() != "dinner" &&
                userTyped.lowercase() != "dinner-snack"
            ) {
                textInput.error = "Invalid! Try: Morning, Mid-Morning, Afternoon-Lunch, Afternoon-Snack, Dinner, Dinner-Snack."
                outputText.text = ""
                return@setOnClickListener
            }

            // Long if/else chain (instead of when)
            var meal = ""
            if (userTyped.equals("morning", true)) {
                meal = "Suggested Meal: Eggs and Toast"
            } else if (userTyped.equals("mid-morning", true)) {
                meal = "Suggested Meal: Greek yogurt and mixed berries"
            } else if (userTyped.equals("afternoon-lunch", true)) {
                meal = "Suggested Meal: Sandwich and Juice , Pizza Lava Toast"
            } else if (userTyped.equals("afternoon-snack", true)) {
                meal = "Suggested Meal: Yogurt Granola Frozen Banana"
            } else if (userTyped.equals("dinner", true)) {
                meal = "Suggested Meal: Grilled Chicken and Salad"
            } else if (userTyped.equals("afternoon-snack", true)) {
                meal = "Suggested Meal: Ice Cream and Chocolate Cake"
            } else {
                meal = "Error: No meal found"
            }


            outputText.text = meal
        }

        buttonReset.setOnClickListener {
            textInput.text.clear()
            outputText.text = "Cleared!"
            outputText.text = ""
            textInput.error = null
        }
    }
}