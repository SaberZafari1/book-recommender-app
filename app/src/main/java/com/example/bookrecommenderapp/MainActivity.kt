package com.example.bookrecommenderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val eTPrompt = findViewById<EditText>(R.id.getBRid)
        val btnSubmit = findViewById<Button>(R.id.promptBtn)
        val btnNext = findViewById<Button>(R.id.nextBtn)
        val tVResult = findViewById<TextView>(R.id.recoTxtV)


        tVResult.movementMethod = ScrollingMovementMethod()

        btnSubmit.setOnClickListener {
            val prompt = eTPrompt.text.toString()

            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = "AIzaSyBzN5z5D3nwzOL9YLqFVLIrgnosoA6na08"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tVResult.text = response.text
            }
            eTPrompt.text.clear()
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}

