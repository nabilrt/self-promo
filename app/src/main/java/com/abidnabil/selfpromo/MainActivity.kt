package com.abidnabil.selfpromo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
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
        val spinnerValues: Array<String> =
            arrayOf("Junior Software Engineer", "HR", "Manager", "CEO", "CTO")
        val SpinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)

        jobTitleSpinner?.adapter = SpinnerAdapter;

    }

    private fun onGetViews() {
        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        displayNameEditText = findViewById(R.id.edit_text_my_display_name)
        availableFromDateEditText = findViewById(R.id.edit_text_available_date)
        includeJuniorCheckbox = findViewById(R.id.check_box_junior)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)
        immediateStartCheckbox = findViewById(R.id.check_box_immidiate_start)
    }

    private fun onPreviewClicked() {
        val contactName = contactNameEditText?.text.toString()
        val contactNumber = contactNumberEditText?.text.toString()
        val displayName = displayNameEditText?.text.toString()
        val includeJunior = includeJuniorCheckbox?.isChecked?.toString()
        val jobTitle = jobTitleSpinner?.selectedItem?.toString()
        val immediateStart = immediateStartCheckbox?.isChecked
        val startDate = availableFromDateEditText?.text.toString()

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("Display Name", displayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)
        startActivity(previewActivityIntent)


    }
}