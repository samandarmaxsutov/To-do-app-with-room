package uz.it_school_.todoappwithroom.view.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class MyHelper(private val adapter: ToDoAdapter) : ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT, ItemTouchHelper.RIGHT) {
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {

//        adapter.onMove(viewHolder.adapterPosition, target.adapterPosition)
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (isLongPressDragEnabled) {
            adapter.removeItem(viewHolder.adapterPosition)
        }
    }

}