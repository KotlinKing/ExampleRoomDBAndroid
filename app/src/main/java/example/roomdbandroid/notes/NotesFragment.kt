package example.roomdbandroid.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.roomdbandroid.data.NoteItem
import example.roomdbandroid.data.NotesAdapter
import example.roomdbandroid.data.NotesViewModel
import example.roomdbandroid.databinding.FragmentNotesBinding

class NotesFragment : Fragment(), OnRecyclcerViewItemClick {

    private lateinit var mNotesViewModel: NotesViewModel

    private lateinit var binding: FragmentNotesBinding
    private lateinit var notesAdapter: NotesAdapter
    var notesFull: Boolean = false
    var totalNotesAmount: Float = 0.0f
    //private val TAG = javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesAdapter = NotesAdapter()
        notesAdapter.setOnRecyclerItemClick(this)
        binding.notesRyclerView.adapter = notesAdapter

        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        mNotesViewModel.readAllNotes.observe(viewLifecycleOwner, Observer { notes ->
            notesAdapter.setData(notes)
        })

        binding.btnSave.setOnClickListener {
            val notesTitle = binding.etTxtNote.text.toString()
            val notes = NoteItem(0, notesTitle)
            mNotesViewModel.addNote(notes)
            binding.etTxtNote.text?.clear()
        }

        binding.btnDelete.setOnClickListener {
            mNotesViewModel.deleteAllNotes()
        }

    }

    fun addNoteToNotes(view: View, position: Int) {

    }

    fun deleteNoteFromNotes(view: View, noteItem: NoteItem) {
        mNotesViewModel.deleteNote(noteItem)
    }

    private fun deleteAllProducstFromNotes() {
        mNotesViewModel.deleteAllNotes()
        notesFull = false
    }

    override fun showToast(view: View, position: Int) {
        Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show()
    }

    override fun deleteNote(view: View, currentItem: NoteItem) {
        deleteNoteFromNotes(view,currentItem)
    }

}