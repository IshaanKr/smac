package com.icg.smac.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.icg.smac.R
import com.icg.smac.databinding.FragmentCreateTicketBinding
import com.icg.smac.databinding.FragmentDashboardBinding
import com.icg.smac.dummyItems
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateTicketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateTicketFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentCreateTicketBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateTicketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (binding.contractorNameTv as? MaterialAutoCompleteTextView)?.run {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.drop_down_item,
                    dummyItems
                )
            )
        }

        (binding.unitTv as? MaterialAutoCompleteTextView)?.run {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.drop_down_item,
                    dummyItems
                )
            )
        }

        (binding.equipmentNameTv as? MaterialAutoCompleteTextView)?.run {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.drop_down_item,
                    dummyItems
                )
            )
        }

        (binding.equipmentTypeTv as? MaterialAutoCompleteTextView)?.run {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.drop_down_item,
                    dummyItems
                )
            )
        }

        (binding.serviceTypeTv as? MaterialAutoCompleteTextView)?.run {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.drop_down_item,
                    dummyItems
                )
            )
        }

        binding.textInputLayout7.setEndIconOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()

            picker.addOnPositiveButtonClickListener {
                binding.dateTv.setText(Date(picker.selection!!).toGMTString())
            }
            picker.show(parentFragmentManager, "date-picker")
        }


        binding.cancelButton.setOnClickListener { findNavController().navigate(R.id.action_createTicketFragment_to_dashboardFragment) }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateTicketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}