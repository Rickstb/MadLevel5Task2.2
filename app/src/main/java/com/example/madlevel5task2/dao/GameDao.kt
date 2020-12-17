package com.example.madlevel5task2.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.model.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertNote(game: Game)

    @Query("SELECT * FROM NoteTable")
    fun getNotepad(): LiveData<List<Game>>

    @Delete
    suspend fun deleteNote(game: Game)

    @Query("Delete From noteTable")
    suspend fun deleteAllGames()

}
