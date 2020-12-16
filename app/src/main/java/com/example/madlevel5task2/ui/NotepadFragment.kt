package com.example.madlevel5task2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.adapter.StartAdapter
import com.example.madlevel5task2.model.Note
import com.example.madlevel5task2.model.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notepad.*
import kotlinx.android.synthetic.main.item_list.*


class NotepadFragment : Fragment() {

    private val list: ArrayList<Note> = arrayListOf()
    private val startAdapter: StartAdapter = StartAdapter(list)

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notepad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.adapter = startAdapter
        rvList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        observeAddNoteResult()

        createItemTouchHelper().attachToRecyclerView(rvList)
    }

    private fun observeAddNoteResult() {
        viewModel.noteList.observe(viewLifecycleOwner, Observer { notes ->
            list.clear()
            list.addAll(notes)
            startAdapter.notifyDataSetChanged()
        })
    }

    private fun createItemTouchHelper(): ItemTouchHelper {


        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                viewModel.deleteNote(list[position])

            }
        }
        return ItemTouchHelper(callback)
    }

}
