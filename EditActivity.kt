package com.example.watermark

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity(R.layout.activity_edit) {
    private val imageView: ImageView by lazy { findViewById<ImageView>(R.id.image_view) }
    private val getContentButton: View by lazy { findViewById<View>(R.id.get_content_button) }

    private val hasCameraFeature get() = packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableNormalFunction()
        when {
            hasCameraFeature -> enableCameraFunction()
            else             -> disableCameraFunction()
        }
    }

    private fun enableNormalFunction() {
        // 実機に保存されている content を mimeType 指定で取得する。
        val getContent = registerForActivityResult(ActivityResultContracts.GetContent(), this::onContent)
        getContentButton.setOnClickListener { getContent.launch("image/*") }

    }

    private fun enableCameraFunction() {

    }

    private fun disableCameraFunction() {

    }

    private fun onContent(uri: Uri?) {
        imageView.setImageURI(uri ?: return)
    }

    private fun onPicture(bitmap: Bitmap?) {
        imageView.setImageBitmap(bitmap ?: return)
    }
}