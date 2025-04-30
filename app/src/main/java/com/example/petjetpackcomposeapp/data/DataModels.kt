package com.example.petjetpackcomposeapp.data

import com.example.petjetpackcomposeapp.domain.Character

data class CharacterResponse(
    val results: List<CharacterDto>
)

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)

fun CharacterDto.toDomain(): Character {
    return Character(id, name, status, species, image)
}

