package com.example.login

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class HomeActivity : AppCompatActivity() {

    companion object {
        private const val PERMISSION_REQUEST_LOCATION = 100
    }

    private lateinit var btnTrackLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnTrackLocation = findViewById(R.id.btnTrackLocation)
        btnTrackLocation.setOnClickListener {
            trackCurrentLocation()
        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_LOCATION
            )
        } else {
            btnTrackLocation.visibility = View.VISIBLE
        }
    }

    private fun trackCurrentLocation() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val latitude = location.latitude
                val longitude = location.longitude
                Log.d("Location", "Latitude: $latitude, Longitude: $longitude")

                val message = "Latitude: $latitude\nLongitude: $longitude"
                Toast.makeText(this@HomeActivity, message, Toast.LENGTH_SHORT).show()
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle?) {}

            override fun onProviderEnabled(provider: String) {}

            override fun onProviderDisabled(provider: String) {}
        }
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Izin lokasi tidak diberikan.", Toast.LENGTH_SHORT).show()
            return
        }
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            0,
            0f,
            locationListener
        )
        locationManager.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER,
            0,
            0f,
            locationListener
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnTrackLocation.visibility = View.VISIBLE
                } else {
                    Toast.makeText(this, "Izin lokasi tidak diberikan.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}