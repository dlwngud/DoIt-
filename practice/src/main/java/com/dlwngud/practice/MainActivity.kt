package com.dlwngud.practice

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.dlwngud.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            // 위치 권한을 체크하고 요청하는 함수 호출
            checkLocationPermission()
        }
    }

    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this, ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    ACCESS_FINE_LOCATION
                )
            ) {
                Toast.makeText(this, "앱 실행을 위해서는 권한을 설정해야 합니다.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        ACCESS_FINE_LOCATION,
                        ACCESS_COARSE_LOCATION
                    ),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        ACCESS_FINE_LOCATION,
                        ACCESS_COARSE_LOCATION
                    ), LOCATION_PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 위치 권한이 허용된 경우에 대한 처리
                    Toast.makeText(this, "앱 실행을 위한 권한이 설정 되었습니다", Toast.LENGTH_SHORT).show()
                } else {
                    // 위치 권한이 거부된 경우에 대한 처리
                    showPermissionDeniedDialog()
                    Toast.makeText(this, "앱 실행을 위한 권한이 취소 되었습니다", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun showAppSettingsDialog() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun showPermissionDeniedDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.apply {
            setTitle("권한 거부")
            setMessage("앱 설정으로 이동하여 위치 권한을 활성화해주세요.")
            setPositiveButton("설정으로 이동") { _, _ ->
                showAppSettingsDialog()
            }
            setNegativeButton("취소") { dialog, _ ->
                dialog.dismiss()
            }
        }
        val dialog = alertDialogBuilder.create()
        dialog.show()
    }
}