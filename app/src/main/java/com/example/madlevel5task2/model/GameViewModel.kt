package com.example.madlevel5task2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val mainScope = CoroutineScope(Dispatchers.Main)


    private val noteRepository =  GameRepository(application.applicationContext)

   val gameList:LiveData<List<Game>> = noteRepository.getNotepad()

    fun insertNote(game: Game){
        if (isNoteValid(game)){
            mainScope.launch { noteRepository.insert(game) }
        }
    }

    fun deleteNote(game: Game){
        mainScope.launch { noteRepository.deleteNote(game) }
            }

    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    private fun isNoteValid(game: Game): Boolean {
        return if ( game.title.isBlank()) {
               error.value = "Title must not be empty"
                false
            }
            else {
                success.value = true

                true
        }
    }


}