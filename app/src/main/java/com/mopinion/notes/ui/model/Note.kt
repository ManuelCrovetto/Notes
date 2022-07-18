package com.mopinion.notes.ui.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

data class Note(val note: String, var isDeleteIconVisible: MutableState<Boolean> = mutableStateOf(false))