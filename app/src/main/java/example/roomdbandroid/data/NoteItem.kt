package example.roomdbandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val NoteTitle: String,
)