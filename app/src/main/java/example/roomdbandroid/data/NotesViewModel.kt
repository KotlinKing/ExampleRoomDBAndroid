package example.roomdbandroid.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val readAllNotes: LiveData<List<NoteItem>>
    val getNotesCount: LiveData<Int>
    private val repository: NotesRepository

    init {
        val noteDao = NotesDatabase.getDatabase(application).notesDao()
        repository = NotesRepository(noteDao)
        readAllNotes = repository.readAllData
        getNotesCount = repository.getCount
    }

    fun addNote(noteItem: NoteItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(noteItem)
        }
    }

    fun deleteNote(noteItem: NoteItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(noteItem)
        }
    }

    fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllNotes()
        }
    }
}