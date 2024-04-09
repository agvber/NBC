package com.agvber.apple_market

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.agvber.apple_market.data.PreviewDataBase
import com.agvber.apple_market.data.PreviewDataSource
import com.agvber.apple_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val db: PreviewDataSource = PreviewDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        createNotificationChannel()
        onBackPressedDispatcher.addCallback(this@MainActivity) {
            showAlertDialog()
        }

        binding.notificationImageView.setOnClickListener {
            showNotification(1, getNotificationBuilder())
        }

        binding.mainRecyclerView.adapter = MainAdapter(db.getItem())
        binding.mainRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun showNotification(
        id: Int,
        notification: Notification,
    ) {
        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.require_notification_permission),
                    Toast.LENGTH_SHORT
                ).show()
                return@with
            }
            // notificationId is a unique int for each notification that you must define.
            notify(id, notification)
        }
    }

    private fun getNotificationBuilder(): Notification {
        return NotificationCompat.Builder(this, KEYWORD_NOTIFICATION_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle(getString(R.string.notificationTitle))
            .setContentText(getString(R.string.notificationContent))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.notificationTitle)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(KEYWORD_NOTIFICATION_ID, name, importance)
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showAlertDialog() {
        val dialog = AlertDialog.Builder(this).run {
            setIcon(R.drawable.ic_sms)
            setTitle(getString(R.string.exit_dialog_title))
            setMessage(getString(R.string.exit_dialog_content))
            setPositiveButton(getString(R.string.exit_dialog_positive_button)) { _, _ -> finish() }
            setNegativeButton(getString(R.string.exit_dialog_negative_button)) { _, _ -> }
            create()
        }
        dialog.show()
    }

    companion object {

        const val KEYWORD_NOTIFICATION_ID = "keyword_notification"
    }
}