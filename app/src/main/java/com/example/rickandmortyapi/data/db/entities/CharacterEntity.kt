package com.example.rickandmortyapi.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity
data class CharacterEntity (
    @ColumnInfo(name = "created")
    val created: String = "",
    @ColumnInfo(name = "gender")
    val gender: String = "",
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "characterId")
    val id: Int = 0,
    @ColumnInfo(name = "image")
    val image: String = "",
    @Embedded
    val location: CharacterDBLocation = CharacterDBLocation(),
    @ColumnInfo(name = "name")
    val name: String = "",
    @Embedded
    val origin: CharacterDBOrigin = CharacterDBOrigin(),
    @ColumnInfo(name = "species")
    val species: String = "",
    @ColumnInfo(name = "status")
    val status: String = "",
    @ColumnInfo(name = "type")
    val type: String = "",
    @ColumnInfo(name = "url")
    val url: String = ""
)



data class CharacterWithEpisodes(
    @Embedded
    val characterEntity: CharacterEntity = CharacterEntity(),
    @Relation(
        parentColumn = "characterId",
        entityColumn = "episodeId",
        associateBy = Junction(CharactersAndEpisodesIdsEntity::class)
    )
    val episodes: List<EpisodeEntity> = emptyList()
)


data class CharacterDBLocation(
    @ColumnInfo(name = "location_name")
    val name: String = "",
    @ColumnInfo(name = "location_url")
    val url: String = ""
)

data class CharacterDBOrigin(
    @ColumnInfo(name = "origin_name")
    val name: String = "",
    @ColumnInfo(name = "origin_url")
    val url: String = ""
)


