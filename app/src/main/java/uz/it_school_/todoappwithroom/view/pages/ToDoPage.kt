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
import uz.it_school_.todoappwithroom.databinding.PageToDoBinding

import uz.it_school_.todoappwithroom.presenter.viewmodels.ToDoViewModel
import uz.it_school_.todoappwithroom.presenter.viewmodels.impl.ToDoViewModelImpl
import uz.it_school_.todoappwithroom.view.adapter.MyHelper
import uz.it_school_.todoappwithroom.view.adapter.ToDoAdapter

class ToDoPage:Fragment(R.layout.page_to_do) {
    private var _binding: PageToDoBinding? = null
    private var itemPressListener:((ToDoEntity)->Unit)?=null
    private var itemEdit:((ToDoEntity)->Unit)?=null
    private val binding get() = _binding!!
    private val navController:NavController by lazy { findNavController() }
    private val viewModel: ToDoViewModel by viewModels<ToDoViewModelImpl>()
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
                binding.list.visibility=View.VISIBLE
                binding.imgNoResult.visibility=View.GONE
                adapter.submitList(it)
            }
            else{
                binding.list.visibility=View.GONE
                binding.imgNoResult.visibility=View.VISIBLE
            }

        }
        adapter.removeToDo {
            viewModel.addDoing(it)
            viewModel.delete(it)
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

        val touchCallback = MyHelper(binding.list.adapter as ToDoAdapter)

        val touchHelper = ItemTouchHelper(touchCallback)

        touchHelper.attachToRecyclerView(binding.list)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = PageToDoBinding.inflate(inflater, container, false)
        val view = _binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
            viewModel.delete(item)

            builder.cancel()
        }

        builder.show()

    }

    fun itemPress(l:(ToDoEntity)->Unit){
        itemPressListener=l
    }
    fun itemEditClick(l:(ToDoEntity)->Unit){
        itemEdit=l
    }

}