package com.example.madlevel5task2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val mainScope = CoroutineScope(Dispatchers.Main)


    private val noteRepository =  NoteRepository(application.applicationContext)

   val noteList:LiveData<List<Note>> = noteRepository.getNotepad()

    fun insertNote(note: Note){
        if (isNoteValid(note)){
            mainScope.launch { noteRepository.insert(note) }
        }
    }

    fun deleteNote(note: Note){
        mainScope.launch { noteRepository.deleteNote(note) }
            }

    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    private fun isNoteValid(note: Note): Boolean {
        return if ( note.title.isBlank()) {
               error.value = "Title must not be empty"
                false
            }
            else {
                success.value = true

                true
        }
    }


}