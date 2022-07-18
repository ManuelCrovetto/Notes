package com.mopinion.notes.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.mopinion.notes.R
import com.mopinion.notes.ui.MainActivityViewModel
import com.mopinion.notes.ui.theme.secondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesList(viewModel: MainActivityViewModel = hiltViewModel()) {
    LazyColumn {
        itemsIndexed(viewModel.notesList) { index, item ->
            Card(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(end = 24.dp, start = 24.dp, bottom = 8.dp)
                .fillMaxWidth()
                .clickable {
                    viewModel.toggleDeleteIconVisibility(index)
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                val constraints = ConstraintSet {
                    val noteTitle = createRefFor("noteTitle")
                    val deleteIcon = createRefFor("deleteIcon")
                    constrain(noteTitle) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }
                    constrain(deleteIcon) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }
                }
                ConstraintLayout(constraintSet = constraints,
                    modifier = Modifier
                        .background(secondaryColor)
                        .fillMaxWidth()) {
                    Text(text = item.note,
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                bottom = 8.dp,
                                top = 8.dp,
                                end = 16.dp
                            )
                            .layoutId("noteTitle"),
                        color = Color.White
                    )
                    AnimatedVisibility(visible = viewModel.notesList[index].isDeleteIconVisible.value,
                        modifier = Modifier
                            .layoutId("deleteIcon")
                            .padding(end = 16.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_baseline_delete_24),
                            contentDescription = "Delete icon",
                            colorFilter = ColorFilter.tint(Color.Red),
                            modifier = Modifier.clickable {
                                viewModel.removeItem(index)
                            })
                    }
                }
            }
        }
    }
}