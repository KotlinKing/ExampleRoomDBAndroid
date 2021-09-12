package example.roomdbandroid.notes

import android.view.View
import example.roomdbandroid.data.NoteItem

interface OnRecyclcerViewItemClick {
    fun showToast(view: View,position:Int)
    fun deleteNote(view: View,currentItem: NoteItem)
}