package br.com.paulosales.schedule.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.paulosales.schedule.R
import br.com.paulosales.schedule.ui.dashboard.DashBoardActivity
import java.util.Timer
import java.util.TimerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(
                        Intent(this@SplashActivity, DashBoardActivity::class.java)
                )
                finish()
            }
        }, 3000)
    }
}
