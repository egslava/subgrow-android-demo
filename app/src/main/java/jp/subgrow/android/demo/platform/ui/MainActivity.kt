package jp.subgrow.android.demo.platform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import jp.subgrow.android.demo.R
import jp.subgrow.android.demo.databinding.ActivityMainBinding
import jp.subgrow.android.sdk.B2S


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        B2S.gotPushViaIntent(this)

        firebaseAnalytics = Firebase.analytics

        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.navView

        val navController = findNavController(
            R.id.nav_host_fragment_activity_main,
        )
        navView.setupWithNavController(navController)
    }
}
