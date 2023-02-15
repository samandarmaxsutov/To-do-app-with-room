package uz.it_school_.todoappwithroom.view.screen

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tapadoo.alerter.Alerter
import uz.it_school_.todoappwithroom.R

import uz.it_school_.todoappwithroom.databinding.ScreenAddTodoBinding
import uz.it_school_.todoappwithroom.presenter.viewmodels.AddScreenViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.AddScreenViewModelImpl
import java.util.*


class AddScreen:Fragment(R.layout.screen_add_todo) {
    private var _binding: ScreenAddTodoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddScreenViewModel by viewModels<AddScreenViewModelImpl>()
    private val cal = Calendar.getInstance()
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val day = cal.get(Calendar.DAY_OF_MONTH)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this){
            findNavController().navigateUp()
        }
        viewModel.saveLiveData.observe(this){
           withIcon(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.saveBtn.setOnClickListener{
            viewModel.save(binding.inputTitle.text.toString(),binding.inputDescription.text.toString(),binding.inputDate.text.toString())
        }
        binding.btnDate.setOnClickListener {

            val datePickerDialog = DatePickerDialog(requireContext(), { view, myear, mmonth, mdayOfMonth ->
                    binding.inputDate.setText(""+ mdayOfMonth +"/"+ mmonth +"/"+ myear)
                }, year, month, day)
                datePickerDialog.show()

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ScreenAddTodoBinding.inflate(inflater, container, false)

        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun withIcon(text:String) {
        Alerter.create(requireActivity())
            .setText(text)
            .setIcon(R.drawable.notification)
            .setBackgroundColorRes(R.color.tab_layout_bg)

            .show()
    }
}