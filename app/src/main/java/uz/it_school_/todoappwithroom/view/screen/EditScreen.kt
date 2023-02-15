package uz.it_school_.todoappwithroom.view.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.databinding.ScreenAddTodoBinding
import uz.it_school_.todoappwithroom.databinding.ScreenEditTodoBinding
import uz.it_school_.todoappwithroom.presenter.viewmodels.AddScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.EditScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.AddScreenViewModelImpl
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.EditScreenViewModelImpl

class EditScreen:Fragment(R.layout.screen_edit_todo) {

    private var _binding: ScreenEditTodoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EditScreenViewModel by viewModels<EditScreenViewModelImpl>()
    private val args:EditScreenArgs by navArgs<EditScreenArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this){
            findNavController().navigateUp()
        }
        viewModel.saveLiveData.observe(this){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.inputDate.setText(args.data.date)
        binding.inputTitle.setText(args.data.title)
        binding.inputDescription.setText(args.data.describtion)


        binding.saveBtn.setOnClickListener{
            viewModel.save(args.data.id,binding.inputTitle.text.toString(),binding.inputDescription.text.toString(),binding.inputDate.text.toString())
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ScreenEditTodoBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}