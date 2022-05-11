package com.example.ass9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    val CAMERA_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isCameraExist()){
            Log.i("VIDEO_RECORD_TAG","Camera is detected")
            getCameraPermission()
        }
        else{
            Log.i("VIDEO_RECORD_TAG","No Camera is detected")
        }
    }

    fun isCameraExist(): Boolean {
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }

    fun getCameraPermission(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),CAMERA_PERMISSION_CODE)
        }
    }

    fun recordVideo(view: View){
        startActivity(Intent(MediaStore.ACTION_VIDEO_CAPTURE))
    }

    fun captureImage(view: View){
        startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }

}