package com.abidnabil.selfpromo

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    var contactNameEditText: TextInputEditText? = null
    var contactNumberEditText: TextInputEditText? = null
    var displayNameEditText: TextInputEditText? = null
    var availableFromDateEditText: TextInputEditText? = null
    var includeJuniorCheckbox: CheckBox? = null
    var jobTitleSpinner: Spinner? = null
    var immediateStartCheckbox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onGetViews()
        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }

    }

    private fun onGetViews(){
        contactNameEditText=findViewById(R.id.edit_text_contact_name)
        contactNumberEditText=findViewById(R.id.edit_text_contact_number)
        displayNameEditText=findViewById(R.id.edit_text_my_display_name)
        availableFromDateEditText=findViewById(R.id.edit_text_available_date)
        includeJuniorCheckbox=findViewById(R.id.check_box_junior)
        jobTitleSpinner=findViewById(R.id.spinner_job_title)
        immediateStartCheckbox=findViewById(R.id.check_box_immidiate_start)
    }

    private fun onPreviewClicked() {
        Toast.makeText(this, "Information's Submitted!",Toast.LENGTH_LONG).show()
    }
}