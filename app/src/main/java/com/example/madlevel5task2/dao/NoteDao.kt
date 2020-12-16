package com.example.madlevel5task2.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.model.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM NoteTable")
    fun getNotepad(): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Delete From noteTable")
    suspend fun deleteAllGames()

}
