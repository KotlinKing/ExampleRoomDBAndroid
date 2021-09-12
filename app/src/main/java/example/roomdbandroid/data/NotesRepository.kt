package example.roomdbandroid.data

import androidx.lifecycle.LiveData
import example.roomdbandroid.data.NoteItem
import example.roomdbandroid.data.NotesDao

class NotesRepository(private val notesDao: NotesDao) {

    val readAllData: LiveData<List<NoteItem>> = notesDao.readAllData()
    val getCount: LiveData<Int> = notesDao.getCount()

    suspend fun addNote(noteItem: NoteItem){
        notesDao.addNote(noteItem)
    }

    suspend fun deleteNote(noteItem: NoteItem){
        notesDao.deleteNote(noteItem)
    }

    suspend fun deleteAllNotes(){
        notesDao.deleteAllNotes()
    }
}