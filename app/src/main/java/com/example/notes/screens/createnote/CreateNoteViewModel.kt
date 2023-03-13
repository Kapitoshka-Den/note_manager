package com.example.notes.screens.createnote

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.core.DatabaseDataSource
import com.example.notes.data.datasource.database.notes.NotesDao
import com.example.notes.data.datasource.database.notes.NotesEntity
import com.example.notes.domain.repository.NoteDtoRepo
import com.example.notes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val noteDtoRepo: NoteDtoRepo,
    @DatabaseDataSource private val noteRepository: NoteRepository,
) :
    ViewModel() {

    //initialize state
    private val _note = MutableStateFlow(CreateNoteState.NotesState().notesEntity)
    val note = _note.asStateFlow()

    val calendar = Calendar.getInstance()

    var year = calendar[Calendar.YEAR]
    var month = calendar[Calendar.MONTH]
    var day = calendar[Calendar.DAY_OF_MONTH]

    //show datepicker and pick date for note
    fun showDatePicker(context: Context) {
        val datePicker = DatePickerDialog(
            context,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
                _note.value = note.value.copy(
                    dateOfCompletion = LocalDate.of(
                        selectedYear,
                        selectedMonth,
                        selectedDayOfMonth
                    )
                )
                noteDtoRepo.setDate(_note.value.dateOfCompletion!!)
            }, year, month, day
        )
        datePicker.show()
    }

    //clear note for next creating note, else app won't create new notes
    fun noteClear(){
        noteDtoRepo.noteClear()
    }

    //get note for edit from database
    fun getNote(id: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val noteData = noteRepository.getNotesById(id)
            Log.e("id", noteData.id.toString())

            _note.value =
                note.value.copy(
                    id = noteData.id,
                    title = noteData.title,
                    text = noteData.text,
                    dateOfCompletion = noteData.dateOfCompletion
                )
            noteDtoRepo.setNote(
                NotesEntity(
                    id = id,
                    title = noteData.title,
                    text = noteData.text,
                    dateOfCompletion = noteData.dateOfCompletion
                )
            )
        }
    }

    fun updateTitle(value: String) {
        _note.value = note.value.copy(title = value)
        noteDtoRepo.setTitle(value)
    }

    fun updateDate(value: String) {
        val date = value.split("-")
        Log.e("ets", date[2].toInt().toString())
        val localDate = LocalDate.of(
            date[0].toInt(),
            date[1].toInt(),
            date[2].toInt()
        )
        noteDtoRepo.setDate(localDate)
    }

    fun updateText(value: String) {
        _note.value = note.value.copy(text = value)
        noteDtoRepo.setText(value)
    }
}