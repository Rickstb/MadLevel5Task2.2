package com.example.madlevel5task2.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "noteTable")
data class Note(

        @ColumnInfo(name = "title")
    var title: String,

        @ColumnInfo(name = "release")
    var release: LocalDate,

        @ColumnInfo(name = "text")
    var text: String,

        @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id: Long? = null
)