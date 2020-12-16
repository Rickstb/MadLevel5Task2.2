package com.example.madlevel5task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.dao.NoteDao
import com.example.madlevel5task2.database.NotepadRoomDatabase
import com.example.madlevel5task2.model.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<List<Note>> {
        return noteDao.getNotepad()
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun insert(note: Note){
        noteDao.insertNote(note)
    }

}
