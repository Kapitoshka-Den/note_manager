package com.example.notes.screens.mainscreen

sealed class MainScreenState{
    data class NotesState(var title:String = "", var text:String = "")
}