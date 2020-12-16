package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Note
import com.example.madlevel5task2.model.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_add_note.view.*
import java.time.LocalDate
import java.time.Year

class AddNoteFragment : Fragment(){

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            saveNote()
        }

        observeNote()
    }

    private fun observeNote() {

        viewModel.error.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        })

        viewModel.success.observe(viewLifecycleOwner, Observer {     success ->
            //"pop" the backstack, this means we destroy this    fragment and go back to the RemindersFragment
            findNavController().popBackStack()
        })
    }

    private fun saveNote() {
        var date = LocalDate.of(edYear.editText?.text.toString().toInt(), edMonth.editText?.text.toString().toInt(), edDay.editText?.text.toString().toInt())
        var note = Note(Title.editText?.text.toString(),date ,Text.editText?.text.toString())
        viewModel.insertNote(note)
    }

}

