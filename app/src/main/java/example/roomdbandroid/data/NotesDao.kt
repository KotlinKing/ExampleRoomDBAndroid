package example.roomdbandroid.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(noteItem: NoteItem)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<NoteItem>>

    @Delete
    fun deleteNote(noteItem: NoteItem)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()

    @Query("SELECT COUNT(*) FROM notes_table")
    fun getCount(): LiveData<Int>
}