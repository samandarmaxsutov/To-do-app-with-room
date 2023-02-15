package uz.it_school_.todoappwithroom.view.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import uz.it_school_.todoappwithroom.R
import uz.it_school_.todoappwithroom.data.room.entites.ToDoEntity
import uz.it_school_.todoappwithroom.databinding.DialogDeleteBinding
import uz.it_school_.todoappwithroom.databinding.PageDoingBinding
import uz.it_school_.todoappwithroom.databinding.PageDoneBinding
import uz.it_school_.todoappwithroom.presenter.viewmodels.DoingViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.DoneViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.DoingViewModelImpl
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.DoneViewModelImpl
import uz.it_school_.todoappwithroom.utils.toDoingEntity
import uz.it_school_.todoappwithroom.utils.toDoneEntity
import uz.it_school_.todoappwithroom.utils.toToDoEntity
import uz.it_school_.todoappwithroom.view.adapter.MyHelper
import uz.it_school_.todoappwithroom.view.adapter.ToDoAdapter

class DonePage:Fragment(R.layout.page_done) {
    private var _binding: PageDoneBinding? = null
    private val binding get() = _binding!!
    private var itemEdit:((ToDoEntity)->Unit)?=null
    private var itemPressListener:((ToDoEntity)->Unit)?=null
    private val navController: NavController by lazy { findNavController() }
    private val viewModel: DoneViewModel by viewModels<DoneViewModelImpl>()
    private val adapter by lazy { ToDoAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openDialogLiveData.observe(this){
            deleteDialog(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.list.adapter=adapter
        viewModel.getAllLiveData.observe(viewLifecycleOwner){
            if(it.size>0){
                binding.list.visibility= View.VISIBLE
                binding.imgNoResult.visibility= View.GONE
                adapter.submitList(it.map{ l-> l.toToDoEntity()})
            }
            else{
                binding.list.visibility= View.GONE
                binding.imgNoResult.visibility= View.VISIBLE
            }

        }

        adapter.itemDelete {
            viewModel.openDilaog(it)
        }
        adapter.itemPress {
            itemPressListener?.invoke(it)
        }
        adapter.itemEdit {
            itemEdit?.invoke(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = PageDoneBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun itemPress(l:(ToDoEntity)->Unit){
        itemPressListener=l
    }
    fun itemEditClick(l:(ToDoEntity)->Unit){
        itemEdit=l
    }
    private fun deleteDialog(item:ToDoEntity){
        val builder = AlertDialog.Builder(requireContext(),R.style.CustomAlertDialog).create()
        val binding1=  DialogDeleteBinding.bind(layoutInflater.inflate(R.layout.dialog_delete,null))
        val view: View = binding1.root
        builder.setView(view)
        binding1.noBtn.setOnClickListener {

            builder.cancel()

        }
        binding1.yesBtn.setOnClickListener {
            viewModel.delete(item.toDoneEntity())

            builder.cancel()
        }

        builder.show()

    }
}