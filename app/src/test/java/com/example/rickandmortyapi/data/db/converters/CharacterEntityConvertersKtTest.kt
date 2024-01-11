package com.example.rickandmortyapi.data.db.converters

import com.example.rickandmortyapi.data.db.entities.CharacterDBLocation
import com.example.rickandmortyapi.data.db.entities.CharacterDBOrigin
import com.example.rickandmortyapi.data.db.entities.CharacterEntity
import com.example.rickandmortyapi.data.network.responseModels.ResponseLocation
import com.example.rickandmortyapi.data.network.responseModels.ResponseOrigin
import com.example.rickandmortyapi.domain.models.CharacterModel
import com.example.rickandmortyapi.domain.models.CharacterModelLocation
import com.example.rickandmortyapi.domain.models.CharacterModelOrigin
import org.junit.Assert.*

import org.junit.Test

class CharacterEntityConvertersKtTest {

    private lateinit var characterEntity: CharacterEntity

    private lateinit var characterModel: CharacterModel

    private lateinit var characterModelLocation: CharacterModelLocation

    private lateinit var characterModelOrigin: CharacterModelOrigin

    private lateinit var characterDBLocation: CharacterDBLocation

    private lateinit var characterDBOrigin: CharacterDBOrigin

    private fun initNullableData(){
        characterEntity = CharacterEntity()

        characterModelLocation =
            CharacterModelLocation()
        characterModelOrigin =
            CharacterModelOrigin()

        characterDBLocation =
            CharacterDBLocation()
        characterDBOrigin =
            CharacterDBOrigin()

        characterModel = CharacterModel(
            "", "", 0,
            "", CharacterModelLocation("", ""),
            "", CharacterModelOrigin("", ""),
            "", "", "", ""
        )

    }

    private fun initRegularData(){

        characterModelLocation =
            CharacterModelLocation("location", "url")
        characterModelOrigin =
            CharacterModelOrigin("origin", "url")

        characterDBLocation =
            CharacterDBLocation("location", "url")
        characterDBOrigin =
            CharacterDBOrigin("origin", "url")

        characterEntity = CharacterEntity(
            "24.10.23",
            "male", 2, "url", characterDBLocation,
            "name", characterDBOrigin, "species",
            "status", "type", "url"
        )

        characterModel = CharacterModel(
            "24.10.23",
            "male", 2, "url", characterModelLocation,
            "name", characterModelOrigin, "species",
            "status", "type", "url"
        )
    }

    @Test
    fun dbEntityToCharacterModelWithNullableDataTest() {
        initNullableData()
        val executionResult =  characterEntity.toCharacterModel()
        assertEquals(characterModel, executionResult)
    }

    @Test
    fun dbEntityToCharacterModelWithRegularDataTest() {
        initRegularData()
        val executionResult =  characterEntity.toCharacterModel()
        assertEquals(characterModel, executionResult)
    }

    @Test
    fun dbLocationModelToDomainModelWithNullableDataTest() {
        initNullableData()
        val executionResult =  characterDBLocation.toDomainModel()
        assertEquals(characterModelLocation, executionResult)
    }

    @Test
    fun dbLocationModelToDomainModelWithRegularDataTest() {
        initRegularData()
        val executionResult =  characterDBLocation.toDomainModel()
        assertEquals(characterModelLocation, executionResult)
    }

    @Test
    fun domainLocationModelToDBModelWithNullableDataTest() {
        initNullableData()
        val executionResult = characterModelLocation.toDBModel()
        assertEquals(characterDBLocation, executionResult)
    }

    @Test
    fun domainLocationModelToDBModelWithRegularDataTest() {
        initRegularData()
        val executionResult = characterModelLocation.toDBModel()
        assertEquals(characterDBLocation, executionResult)
    }

    @Test
    fun dbOriginModelToDomainModelWithNullableDataTest() {
        initNullableData()
        val executionResult = characterDBOrigin.toDomainModel()
        assertEquals(characterModelOrigin, executionResult)
    }

    @Test
    fun dbOriginModelToDomainModelWithRegularDataTest() {
        initRegularData()
        val executionResult = characterDBOrigin.toDomainModel()
        assertEquals(characterModelOrigin, executionResult)
    }

    @Test
    fun domainOriginModelToDBModelWithNullableDataTest() {
        initNullableData()
        val executionResult = characterModelOrigin.toDBModel()
        assertEquals(characterDBOrigin, executionResult)
    }

    @Test
    fun domainOriginModelToDBModelWithRegularDataTest() {
        initRegularData()
        val executionResult = characterModelOrigin.toDBModel()
        assertEquals(characterDBOrigin, executionResult)
    }


    @Test
    fun characterModelToDbEntityWithNullableDataTest() {
        initNullableData()
        val executionResult = characterModel.toDbEntity()
        assertEquals(characterEntity, executionResult)
    }

    @Test
    fun characterModelToDbEntityWithRegularDataTest() {
        initRegularData()
        val executionResult = characterModel.toDbEntity()
        assertEquals(characterEntity, executionResult)
    }
}