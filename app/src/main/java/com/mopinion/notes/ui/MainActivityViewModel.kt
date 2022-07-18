package com.mopinion.notes.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.mopinion.notes.ui.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): ViewModel() {

    var textFieldState by mutableStateOf("")
        private set

    var notesList = mutableStateListOf<Note>()
        private set

    fun addNote() {
        if (textFieldState.isNotEmpty()) {
            notesList.add(
                Note(note = textFieldState)
            )
            textFieldState = ""
        }
    }

    fun setText(text: String) {
        textFieldState = text
    }

    fun toggleDeleteIconVisibility(index: Int) {
        notesList[index].isDeleteIconVisible.value = !notesList[index].isDeleteIconVisible.value
    }

    fun removeItem(index: Int) {
        notesList.removeAt(index)
    }
}