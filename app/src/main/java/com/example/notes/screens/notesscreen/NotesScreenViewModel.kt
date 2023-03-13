package com.example.notes.screens.notesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.core.DatabaseDataSource
import com.example.notes.data.datasource.database.notes.NotesDao
import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesScreenViewModel @Inject constructor(@DatabaseDataSource private val noteRepository: NoteRepository):ViewModel() {

    private val _notesList = MutableStateFlow(NotesScreenState.NotesList().notes)
    val notesList = _notesList.asStateFlow()

    fun getNotes(){
        viewModelScope.launch(Dispatchers.Default) {
            _notesList.update { noteRepository.getAllNotes().toMutableList() }
        }
    }
    fun deleteNote(notesEntity: NotesEntity){
        viewModelScope.launch (Dispatchers.Default){
            noteRepository.deleteNote(notesEntity)
            _notesList.update { noteRepository.getAllNotes().toMutableList() }
        }
    }

}