package com.app.androidresultapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result: ActivityResult? ->
        if (result?.resultCode == Activity.RESULT_OK) {
            text_view.text = "We get the result"
        } else {
            text_view.text = "Failed to get result"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_get_result.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            resultContract.launch(intent)
        }
    }
}