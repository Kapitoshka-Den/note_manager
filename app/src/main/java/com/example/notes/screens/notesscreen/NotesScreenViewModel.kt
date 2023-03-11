package com.example.notes.screens.notesscreen

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.datasource.database.DataBase
import com.example.notes.data.datasource.database.tasks.NotesDao
import com.example.notes.data.datasource.database.tasks.NotesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesScreenViewModel @Inject constructor(private val notesDao: NotesDao):ViewModel() {

    private val _notesList = MutableStateFlow(NotesScreenState.NotesList().notes)
    val notesList = _notesList.asStateFlow()

    fun getNotes(){
        viewModelScope.launch(Dispatchers.Default) {
            _notesList.update { notesDao.getAllNotes().toMutableList() }
        }
    }
    fun deleteNote(notesEntity: NotesEntity){
        viewModelScope.launch (Dispatchers.Default){
            notesDao.deleteNote(notesEntity)
            _notesList.update { notesDao.getAllNotes().toMutableList() }
        }
    }

}