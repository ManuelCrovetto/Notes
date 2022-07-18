package com.mopinion.notes.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mopinion.notes.R
import com.mopinion.notes.ui.MainActivityViewModel

@Composable
fun AddNoteButton(viewModel: MainActivityViewModel = hiltViewModel()) {
    Button(onClick = {
        viewModel.addNote()
    }) {
        Text(color = Color.White,text = stringResource(R.string.add_note_exclamation))
    }
}