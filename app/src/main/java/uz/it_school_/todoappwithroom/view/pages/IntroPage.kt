package uz.it_school_.todoappwithroom.view.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.data.models.IntroPageData
import uz.it_school_.todoappwithroom.databinding.PageIntroBinding

class IntroPage:Fragment(R.layout.page_intro) {
    private var _binding:PageIntroBinding? =null

    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val introPageData:IntroPageData=arguments?.getSerializable("IntroPage") as IntroPageData
       binding.imgPage.setImageResource(introPageData.image)
       binding.txtPage.text=introPageData.title.toString()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = PageIntroBinding.inflate(inflater,container,false)
        val view= _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}