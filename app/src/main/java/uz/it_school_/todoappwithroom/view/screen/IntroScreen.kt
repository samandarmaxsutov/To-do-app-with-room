package uz.it_school_.todoappwithroom.view.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.data.models.IntroPageData
import uz.it_school_.todoappwithroom.databinding.ScreenIntroBinding
import uz.it_school_.todoappwithroom.presenter.viewmodels.IntroScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.IntroScreenViewModelImpl
import uz.it_school_.todoappwithroom.view.adapter.IntroAdapter


class IntroScreen : Fragment(R.layout.screen_intro) {

    private var _binding: ScreenIntroBinding? = null
    private val binding get() = _binding!!
    private val list: ArrayList<IntroPageData> = arrayListOf(
        IntroPageData(R.drawable.img_intro, "Make a clear to-do list."),
        IntroPageData(R.drawable.img_intro, "Make a clear to-do list."),
        IntroPageData(R.drawable.img_intro, "Make a clear to-do list.")

    )
    private val viewModel: IntroScreenViewModel by viewModels<IntroScreenViewModelImpl>()
    private val adapter: IntroAdapter by lazy { IntroAdapter(this, list) }
    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.nextPageLiveData.observe(this) {
            binding.viewPager2.setCurrentItem(it, true)
        }
        viewModel.openMainScreenLiveData.observe(this) {
            navController.navigate(IntroScreenDirections.actionIntroScreenToMainScreen())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { _, _ -> }.attach()
        binding.next.setOnClickListener {
            viewModel.nextPage(binding.viewPager2.currentItem)
        }
        binding.viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
               if (position==2){
                   binding.next.text="go"
               }
                else{  binding.next.text="next"}
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ScreenIntroBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}