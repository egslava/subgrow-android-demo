package jp.subgrow.android.demo.platform.ui.personalcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import jp.subgrow.android.demo.databinding.FragmentPersonalcodeBinding

class PersonalCodeFragment : Fragment() {

    private var _binding: FragmentPersonalcodeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val cls = PersonalCodeViewModel::class.java
        val vm = ViewModelProvider(this)[cls]

        _binding = FragmentPersonalcodeBinding.inflate(
            inflater,
            container,
            false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        vm.text.observe(
            viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
