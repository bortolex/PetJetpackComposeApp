package com.example.petjetpackcomposeapp.domain

import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<List<Character>>
    fun getCharacter(id: Int): Flow<Character>
}
