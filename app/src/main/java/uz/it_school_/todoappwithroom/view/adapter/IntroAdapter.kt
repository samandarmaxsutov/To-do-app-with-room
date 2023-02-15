package uz.it_school_.todoappwithroom.view.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.it_school_.todoappwithroom.data.models.IntroPageData
import uz.it_school_.todoappwithroom.view.pages.IntroPage

class IntroAdapter(fragment: Fragment,private val list: List<IntroPageData>):FragmentStateAdapter(fragment) {
    override fun getItemCount()=list.size

    override fun createFragment(position: Int): Fragment {
        val page=IntroPage()
        page.arguments = bundleOf(Pair("IntroPage",list[position]) )
        return page
    }
}