package uz.it_school_.todoappwithroom.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zerobranch.layout.SwipeLayout
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity


class ToDoAdapter:ListAdapter<ToDoEntity,ToDoAdapter.Holder> (itemCallback) {

    private var listenerRemove:((ToDoEntity)->Unit)?=null

    fun removeToDo(l:(ToDoEntity)->Unit){
        listenerRemove=l
    }
    private var itemDelteListener:((ToDoEntity)->Unit)?=null

    fun itemDelete(l:(ToDoEntity)->Unit){
       itemDelteListener=l
    }

    private var itemEditListener:((ToDoEntity)->Unit)?=null

    fun itemEdit(l:(ToDoEntity)->Unit){
       itemEditListener=l
    }

    private var itemPressListener:((ToDoEntity)->Unit)?=null

    fun itemPress(l:(ToDoEntity)->Unit){
       itemPressListener=l
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView =view.findViewById(R.id.title_item)
        val date: TextView =view.findViewById(R.id.date_item)
        val delete: ImageView=view.findViewById(R.id.deleteBtn)
        val edit: ImageView=view.findViewById(R.id.editBtn)
        val drag_item:LinearLayout =view.findViewById(R.id.drag_item)
        fun bind() {
            val item=getItem(adapterPosition)
            title.text=item.title
            date.text=item.date

        }
        init {
            delete.setOnClickListener{
                itemDelteListener?.invoke(getItem(adapterPosition))
            }
           edit.setOnClickListener{
                itemEditListener?.invoke(getItem(adapterPosition))
            }

           drag_item.setOnClickListener {
                itemPressListener?.invoke(getItem(adapterPosition))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind()
    fun removeItem(adapterPosition: Int) {
        listenerRemove?.invoke(getItem(adapterPosition))
    }

    object itemCallback : DiffUtil.ItemCallback<ToDoEntity>() {
        override fun areItemsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
            return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.describtion == newItem.describtion && oldItem.date == newItem.date
        }

    }


}





