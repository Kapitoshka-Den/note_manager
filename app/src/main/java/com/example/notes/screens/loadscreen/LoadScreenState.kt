package com.example.notes.screens.loadscreen

sealed class LoadScreenState (){
    data class IsLoad(val isLoad:Boolean = true): LoadScreenState()
}