package com.example.googlemapsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.googlemapsdemo.ui.MapScreen
import com.example.googlemapsdemo.ui.theme.GoogleMapsDemoTheme
import com.example.googlemapsdemo.ui.theme.LocationPermissionScreen
import com.example.googlemapsdemo.utils.checkForPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMapsDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var hasLocationPermission by remember {
                        mutableStateOf(checkForPermission(this))
                    }

                    if(hasLocationPermission){
                        MapScreen(this)
                    }
                    else{
                        LocationPermissionScreen{
                            hasLocationPermission = true;
                        }
                    }
                }
            }
        }
    }
}
