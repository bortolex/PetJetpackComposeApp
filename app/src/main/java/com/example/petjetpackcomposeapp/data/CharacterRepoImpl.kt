package com.example.petjetpackcomposeapp.data

import com.example.petjetpackcomposeapp.domain.Character
import com.example.petjetpackcomposeapp.domain.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override fun getCharacters(): Flow<List<com.example.petjetpackcomposeapp.domain.Character>> = flow {
        val characters = api.getCharacters().results.map { it.toDomain() }
        emit(characters)
    }

    override fun getCharacter(id: Int): Flow<Character> = flow {
        val character = api.getCharacter(id).toDomain()
        emit(character)
    }
}
