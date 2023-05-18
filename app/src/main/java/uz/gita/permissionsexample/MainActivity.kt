package uz.gita.permissionsexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import uz.gita.permissionsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            logger(it.toString())
        }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val smsPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED

        val contactPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED

        val storagePermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

        binding.apply {

            btnLocation.setOnClickListener {
                if (locationPermission) {
                    toast("Fine Location permission allowed")
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            btnContact.setOnClickListener {
                if (contactPermission) {
                    toast("Read Contacts permission allowed")
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
                }
            }

            btnSms.setOnClickListener {
                if (smsPermission) {
                    toast("READ SMS permission allowed")
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.READ_SMS)
                }
            }

            btnStorage.setOnClickListener {
                if (storagePermission) {
                    toast("WRITE STORAGE permission allowed")
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }
        }
    }
}