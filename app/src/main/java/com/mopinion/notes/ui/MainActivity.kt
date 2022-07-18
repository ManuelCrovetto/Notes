package com.mopinion.notes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.mopinion.notes.R
import com.mopinion.notes.ui.components.AddNoteButton
import com.mopinion.notes.ui.components.AppTitle
import com.mopinion.notes.ui.components.NotesInputTextField
import com.mopinion.notes.ui.components.NotesList
import com.mopinion.notes.ui.theme.NotesTheme
import com.mopinion.notes.ui.theme.secondaryColor
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                Scaffold (modifier = Modifier.fillMaxSize(),
                ){ padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))
                        AppTitle()
                        Spacer(modifier = Modifier.height(24.dp))
                        NotesInputTextField()
                        Spacer(modifier = Modifier.height(16.dp))
                        AddNoteButton()
                        Spacer(modifier = Modifier.height(24.dp))
                        NotesList()
                    }
                }
            }
        }
    }
}

