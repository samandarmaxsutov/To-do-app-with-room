package uz.it_school_.todoappwithroom.view.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.databinding.ScreenMainBinding
import uz.it_school_.todoappwithroom.databinding.ScreenReadToDoBinding

class ReadScreen:Fragment(R.layout.screen_read_to_do) {

    private var _binding: ScreenReadToDoBinding? = null
    private val binding get() = _binding!!
    private val args:ReadScreenArgs by navArgs<ReadScreenArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dataRead.text=args.data.date
        binding.titleRead.text=args.data.title
        binding.descriptionRead.text=args.data.describtion
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ScreenReadToDoBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}