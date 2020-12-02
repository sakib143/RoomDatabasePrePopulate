package com.example.testingdatabase.db.table

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.neovisionaries.i18n.CountryCode

@Entity(
    tableName = "namaz_list",
    indices = [
        Index(name = "namaz_name", value = ["name"])
    ]
)

data class NamazList(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
