// photogalleryapp/Activites/HomeScreen.kt
package com.example.photogalleryapp.Activites

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.photogalleryapp.R
import com.example.photogalleryapp.ViewModel.PhotoViewModel
import com.example.photogalleryapp.databinding.ActivityHomeScreenBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : AppCompatActivity() {

    private lateinit var themeSwitch: SwitchMaterial
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter

    private lateinit var networkStatusImageView: ImageView
    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        themeSwitch = binding.switchMode
        recyclerView = binding.photoListRv
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        photoAdapter = PhotoAdapter(emptyList())
        recyclerView.adapter = photoAdapter

        networkStatusImageView = binding.networkStatusIcon

        setupThemeSwitch()
        setupNetworkStatusMonitor()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.loading.collect { isLoading ->
                        binding.loadingIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
                    }
                }

                launch {
                    viewModel.photos.collect { photoList ->
                        photoAdapter.updatePhotos(photoList)
                        if (photoList.isNotEmpty() && photoAdapter.itemCount > 0) {
                            val initialScrollPosition = photoAdapter.itemCount / 2
                            (recyclerView.layoutManager as? StaggeredGridLayoutManager)?.scrollToPosition(initialScrollPosition)
                        }
                    }
                }

                launch {
                    viewModel.error.collect { errorMessage ->
                        Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_LONG)
                            .setAction("إعادة المحاولة") {
                                viewModel.fetchPhotos(forceRefresh = true)
                            }
                            .show()
                    }
                }
            }
        }
    }

    private fun setupThemeSwitch() {
        sharedPreferences = getSharedPreferences("Mood", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        val nightMode = sharedPreferences.getBoolean("night_mode", false)

        AppCompatDelegate.setDefaultNightMode(
            if (nightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )

        themeSwitch.isChecked = nightMode

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            editor.putBoolean("night_mode", isChecked)
            editor.apply()

            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )

            recreate()
        }
    }

    private fun setupNetworkStatusMonitor() {
        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                runOnUiThread { updateNetworkStatusIcon(true) }
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                runOnUiThread { updateNetworkStatusIcon(false) }
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val isConnected =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                runOnUiThread { updateNetworkStatusIcon(isConnected) }
            }
        }

        updateNetworkStatusIcon(isNetworkAvailable())

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    private fun updateNetworkStatusIcon(isConnected: Boolean) {
        if (isConnected) {
            networkStatusImageView.setImageResource(R.drawable.online_network_wifi_24)
        } else {
            networkStatusImageView.setImageResource(R.drawable.no_internet_4_24)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}
