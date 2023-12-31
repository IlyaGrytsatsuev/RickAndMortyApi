package com.example.rickandmortyapi.data.db.converters

import com.example.rickandmortyapi.data.db.entities.CharacterEntity
import com.example.rickandmortyapi.domain.models.CharacterModel
import com.example.rickandmortyapi.domain.models.CharacterModelLocation
import com.example.rickandmortyapi.domain.models.CharacterModelOrigin

fun CharacterEntity.toCharacterModel() : CharacterModel {
    val character = this
    return CharacterModel(
        created = character.created,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = character.location.toDomainModel(),
        name = character.name,
        origin = character.origin.toDomainModel(),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}

fun com.example.rickandmortyapi.data.db.entities.CharacterDBLocation?
        .toDomainModel():
        CharacterModelLocation =
    CharacterModelLocation(this?.name?:"", this?.url?:"")

fun CharacterModelLocation
        .toDBModel():
        com.example.rickandmortyapi.data.db.entities.CharacterDBLocation =
    com.example.rickandmortyapi.data.db.entities.CharacterDBLocation(this.name, this.url)


fun com.example.rickandmortyapi.data.db.entities.CharacterDBOrigin?
        .toDomainModel() : CharacterModelOrigin =
    CharacterModelOrigin(this?.name?:"", this?.url?:"")

fun CharacterModelOrigin
        .toDBModel() :
        com.example.rickandmortyapi.data.db.entities.CharacterDBOrigin =
    com.example.rickandmortyapi.data.db.entities.CharacterDBOrigin(this.name, this.url)


fun CharacterModel.toDbEntity() : CharacterEntity{
    val dbCharacterLocation = this.location.toDBModel()
    val dbCharacterOrigin = this.origin.toDBModel()
    return CharacterEntity(
        created = this.created,
        gender = this.gender,
        id = this.id,
        image = this.image,
        location = dbCharacterLocation,
        name = this.name,
        origin = dbCharacterOrigin,
        species = this.species,
        status = this.status,
        type = this.type,
        url = this.url
    )


}