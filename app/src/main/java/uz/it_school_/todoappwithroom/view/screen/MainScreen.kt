package uz.it_school_.todoappwithroom.view.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.databinding.ScreenMainBinding
import uz.it_school_.todoappwithroom.presenter.viewmodels.MainScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.MainScreenViewModelImpl
import uz.it_school_.todoappwithroom.view.adapter.MainAdapter

class MainScreen:Fragment(R.layout.screen_main) {
    private var _binding: ScreenMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainScreenViewModel by viewModels<MainScreenViewModelImpl>()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openAddScreenLiveData.observe(this){
            findNavController().navigate(MainScreenDirections.actionMainScreenToAddScreen())
        }
        viewModel.openReadScreenLiveData.observe(this){
            findNavController().navigate(MainScreenDirections.actionMainScreenToReadScreen(it))
        }
        viewModel.openEditLiveData.observe(this){
            findNavController().navigate(MainScreenDirections.actionMainScreenToEditScreen(it))
        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabText= arrayListOf<String>("todo","doing","done")
        adapter=MainAdapter(this)
        binding.viewPager2.adapter =adapter

        adapter.itemPress {
            viewModel.openRead(it)
        }
        adapter.edit {
            viewModel.openEditScreen(it)
        }
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tabText[position]

        }.attach()

        binding.btnAdd.setOnClickListener {
            viewModel.openAddScreen()
        }

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position==0){
                    binding.btnAdd.visibility=View.VISIBLE
                }
                else{
                    binding.btnAdd.visibility=View.GONE
                }
            }
        })
    }




    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ScreenMainBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}