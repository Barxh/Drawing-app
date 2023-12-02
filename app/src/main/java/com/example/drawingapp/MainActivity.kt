package com.example.drawingapp

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.drawingapp.databinding.ActivityMainBinding
import android.Manifest
import android.content.Intent
import android.provider.MediaStore
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(20f)

        binding.buttonBrush.setOnClickListener {
            showBrushSizeDialog()
        }
        setupColorButtons()

        binding.buttonBackground.setOnClickListener {
            drawingView?.undo()
        }


    }




    private fun setupColorButtons() {
        binding.buttonBlack.setOnClickListener {
            drawingView?.setColor("#000000")
        }
        binding.buttonBlue.setOnClickListener {
            drawingView?.setColor("#0000FF")
        }
        binding.buttonOker.setOnClickListener {

            var color = binding.buttonOker.tag.toString()
            Log.d("color", "setupColorButtons: ${binding.buttonOker.tag.toString()}")
            drawingView?.setColor(binding.buttonOker.tag.toString())
        }
        binding.buttonGreen.setOnClickListener {

            drawingView?.setColor("#00FF00")
        }
        binding.buttonPurple.setOnClickListener {

            drawingView?.setColor("#992DAC")
        }
        binding.buttonRed.setOnClickListener {

            drawingView?.setColor("#FF0000")
        }
        binding.buttonTirkiz.setOnClickListener {

            drawingView?.setColor("#0F9C8F")
        }
        binding.buttonYellow.setOnClickListener {

            drawingView?.setColor("#FFE500")
        }


    }


    private fun showBrushSizeDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size: ")
        val smallButton = brushDialog.findViewById<ImageButton>(R.id.button_small_brush)
        smallButton.setOnClickListener {
            drawingView?.setSizeForBrush(10f)
            brushDialog.dismiss()
        }

        val mediumButton = brushDialog.findViewById<ImageButton>(R.id.button_medium_brush)
        mediumButton.setOnClickListener {
            drawingView?.setSizeForBrush(20f)
            brushDialog.dismiss()
        }

        val largeButton = brushDialog.findViewById<ImageButton>(R.id.button_large_brush)
        largeButton.setOnClickListener {
            drawingView?.setSizeForBrush(30f)
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}