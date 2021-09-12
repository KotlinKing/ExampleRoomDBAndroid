package example.roomdbandroid.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.roomdbandroid.notes.OnRecyclcerViewItemClick
import example.roomdbandroid.databinding.NoteItemBinding
import java.util.Collections.emptyList

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private var notesList = emptyList<NoteItem>()
    var onRecyclcerViewItemClick: OnRecyclcerViewItemClick? = null

    inner class ViewHolder(val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = notesList[position]

        holder.binding.txtNotesTitle.text = currentItem.NoteTitle

        holder.binding.txtNotesTitle.setOnClickListener {
            onRecyclcerViewItemClick?.showToast(it, position)
        }

        holder.binding.btnDeleteNote.setOnClickListener {
            onRecyclcerViewItemClick?.deleteNote(it,currentItem)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size;
    }

    fun setData(noteItem: List<NoteItem>) {
        this.notesList = noteItem
        notifyDataSetChanged()
    }

    fun setOnRecyclerItemClick(onRecyclcerViewItemClick: OnRecyclcerViewItemClick) {
        this.onRecyclcerViewItemClick = onRecyclcerViewItemClick
    }
}