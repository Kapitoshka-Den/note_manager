package com.example.notes

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.notes.core.navcontrollers.GlobalNavController
import com.example.notes.core.themes.Black
import com.example.notes.core.themes.LightTheme
import com.example.notes.core.themes.Red600
import com.example.notes.core.themes.Red900
import com.example.notes.ui.theme.NotesTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {

                val sharedPref = getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                val systemUiController = rememberSystemUiController()

                val isDarkMode = remember { mutableStateOf(sharedPref.getBoolean("isDark",false)) }


                fun darkChange(){
                    isDarkMode.value = !isDarkMode.value
                    editor.putBoolean("isDark",isDarkMode.value)
                    editor.apply()
                }

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = if(isDarkMode.value) Black else Red600,
                        darkIcons = !isDarkMode.value
                    )
                }
                // A surface container using the 'background' color from the theme
                LightTheme ({ GlobalNavController { darkChange() } },isDarkMode.value )

            }
        }
    }
}