package com.example.notes.screens.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.notes.core.navcontrollers.NavControl
import com.example.notes.data.datasource.database.tasks.NotesDao
import com.example.notes.domain.repository.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val notesDao: NotesDao,
    private val noteRepo: NoteRepo
) : ViewModel() {

    private val _note = MutableStateFlow(MainScreenState.NotesState())
    val note = _note.asStateFlow()

    fun saveNote(navHostController: NavHostController) {
        viewModelScope.launch(Dispatchers.Default) {
            notesDao.insertNotes(noteRepo.getNote())
        }
        navHostController.navigate(NavControl.NotesScreen.route) {
            popUpTo(NavControl.CreateNote.route) {
                inclusive = true
            }
        }
    }

}