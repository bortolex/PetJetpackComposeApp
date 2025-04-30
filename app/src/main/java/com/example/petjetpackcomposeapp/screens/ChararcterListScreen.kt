package com.example.petjetpackcomposeapp.screens

import ads_mobile_sdk.h6
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.petjetpackcomposeapp.domain.Character


@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel = hiltViewModel(), onCharacterClick: (Int) -> Unit) {
    val characters by viewModel.state.collectAsState()

    LazyColumn {
        items(characters) { character ->
            CharacterItem(character = character, onClick = { onCharacterClick(character.id) })
        }
    }
}

@Composable
fun CharacterItem(character: Character, onClick: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick() }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = "${character.species} - ${character.status}", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
