package com.example.notes.screens.settingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.datasource.database.DataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val dataBase: DataBase):ViewModel() {

    fun clearData(){
        viewModelScope.launch(Dispatchers.Default) {
            dataBase.clearAllTables()

        }
    }
}