package com.example.notes.screens.loadscreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.notes.core.navcontrollers.GlobalNavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoadScreenViewModel @Inject constructor() :ViewModel() {

    private val _waitState = MutableStateFlow(LoadScreenState.IsLoad())
    val waitState = _waitState.asStateFlow();

    //imitation loading to app
    suspend fun CloseWait(navHostController: NavHostController){
        delay(timeMillis = 3000L)
        _waitState.value = waitState.value.copy(isLoad = false)

        navHostController.navigate(GlobalNavControl.MainScreen.route){
            popUpTo(GlobalNavControl.LoadScreen.route){
                inclusive = true
            }
        }

    }

}