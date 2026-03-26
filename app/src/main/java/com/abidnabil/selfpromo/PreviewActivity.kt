package com.abidnabil.selfpromo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String
    var previewMessageTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupButton()


    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messagePreviewText = """
            Hi ${message.contactName},
            
            My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
            I have a portfolio of apps to demonstrate if requested.
            I am able to start a new position ${message.getAvailablity()}
            Please get in touch if you have any suitable roles for me.
            Thanks and best regards
            
        """.trimIndent()

        previewMessageTextView = findViewById(R.id.text_view_message)
        previewMessageTextView?.text = messagePreviewText

    }

    private fun setupButton() {
        val previewButton: Button = findViewById(R.id.button_send_message);
        previewButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "smsto: ${message.contactNumber}".toUri()
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}