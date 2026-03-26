package com.abidnabil.selfpromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {
    var previewMessageTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        val message = intent.getSerializableExtra("Message") as Message
        val messagePreviewText = """
            Hi ${message.contactName},
            
            My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
            I have a portfolio of apps to demonstrate if requested.
            I am able to start a new position ${message.getAvailablity()}
            Please get in touch if you have any suitable roles for me.
            Thanks and best regards
            
        """.trimIndent()

        previewMessageTextView = findViewById(R.id.text_view_message)
        previewMessageTextView?.setText(messagePreviewText);


    }
}