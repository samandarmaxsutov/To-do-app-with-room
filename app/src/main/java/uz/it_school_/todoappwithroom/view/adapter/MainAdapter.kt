package uz.it_school_.todoappwithroom.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.view.pages.DoingPage
import uz.it_school_.todoappwithroom.view.pages.DonePage
import uz.it_school_.todoappwithroom.view.pages.ToDoPage

class MainAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    private var itemPressListener:((ToDoEntity)->Unit)?=null
    private var itemEditListener:((ToDoEntity)->Unit)?=null

    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0->{

                val page=ToDoPage()
                page.itemPress {
                itemPressListener?.invoke(it)}
                page.itemEditClick {
                    itemEditListener?.invoke(it)
                }
                page
            }

            1->{

                val page=DoingPage()
                page.itemPress {
                    itemPressListener?.invoke(it)}
                page.itemEditClick {
                    itemEditListener?.invoke(it)
                }
                page
            }
            else->{
                val page=DonePage()
                    page.itemPress {
                        itemPressListener?.invoke(it)
                    }
                    page.itemEditClick {
                        itemEditListener?.invoke(it)
                    }
                    page
                }

            }            }
         fun itemPress(l:(ToDoEntity)->Unit){
             itemPressListener=l
         }
         fun edit(l:(ToDoEntity)->Unit){
             itemEditListener=l
         }
}