package com.example.madlevel5task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.dao.GameDao
import com.example.madlevel5task2.database.NotepadRoomDatabase
import com.example.madlevel5task2.model.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        gameDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<List<Game>> {
        return gameDao.getNotepad()
    }

    suspend fun deleteNote(game: Game) {
        gameDao.deleteNote(game)
    }

    suspend fun insert(game: Game){
        gameDao.insertNote(game)
    }

}
