package com.mopinion.notes.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mopinion.notes.ui.MainActivityViewModel

@Composable
fun NotesInputTextField(viewModel: MainActivityViewModel = hiltViewModel()) {
    OutlinedTextField(
        value = viewModel.textFieldState,
        label = {
            Text(text = "Enter a note...")
        },
        onValueChange = { onValueChange ->
            viewModel.setText(onValueChange)
        },
        )
}