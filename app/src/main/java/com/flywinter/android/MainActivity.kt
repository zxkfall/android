package com.flywinter.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.flywinter.android.databinding.ActivityMainBinding
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()


    }

    /**
     * A native method that is implemented by the 'android' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun stringFromJNICopy(): String

    companion object {
        private var TAG: String = "MainActivity"

        // Used to load the 'android' library on application startup.
        init {
            System.loadLibrary("android")
            if (OpenCVLoader.initDebug()){
                Log.i(TAG, "opencv installed successfully");
            }else{
                Log.i(TAG, "opencv not installed");
            }
        }
    }
}