package com.example.notes.screens.createnote

import androidx.lifecycle.ViewModel
import com.example.notes.domain.repository.NoteRepo
import com.example.notes.screens.mainscreen.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(val noteRepo: NoteRepo) :ViewModel(){

    private val _note = MutableStateFlow(CreateNoteState.NotesState().notesEntity)
    val note = _note.asStateFlow()

    fun updateTitle(value:String){
        _note.value = note.value.copy(title = value)
        noteRepo.setTitle(value)
    }

    fun updateText(value:String){
        _note.value = note.value.copy(text = value)
        noteRepo.setText(value)
    }
}