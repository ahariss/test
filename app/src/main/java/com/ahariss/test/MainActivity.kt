package com.ahariss.test

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavDirections
import com.ahariss.test.databinding.ActivityMainBinding
import com.ahariss.test.mvvm.di.MainAcitvityImp
import com.ahariss.test.mvvm.models.MarvelCharacter
import com.ahariss.test.ui.CharactersFragmentDirections
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainAcitvityImp.Callback {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }




    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun openCharacterDetails(marvelCharacter: MarvelCharacter) {
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        navController.navigate(CharactersFragmentDirections.actionFirstFragmentToSecondFragment(marvelCharacter,marvelCharacter.id.toString()))
    }
}