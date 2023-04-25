package com.example.somativapokemon.model
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.somativapokemon.R

@Suppress("DEPRECATION")
class searchActivity : AppCompatActivity() {
    var imageViewSearch: ImageView? = null
    var buttonSearch: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        imageViewSearch = findViewById(R.id.imageViewSearch)
        buttonSearch = findViewById(R.id.buttonSearch)

        imageViewSearch?.setOnClickListener {
            val imageTakeIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (imageTakeIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    /*fun Camera(view: View?) {
        val imageTakeIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (imageTakeIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE)
        }
    }*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            imageViewSearch!!.setImageURI(data!!.data)
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data!!.extras
            val imageBitmap = extras!!["data"] as Bitmap?
            imageViewSearch!!.setImageBitmap(imageBitmap)
        }
    }
    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 101
        private const val IMAGE_PICK_CODE = 1
    }
}