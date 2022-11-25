package jp.subgrow.android.demo.platform.ui.subscriptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import jp.subgrow.android.demo.R
import jp.subgrow.android.demo.databinding.FragmentSubscriptionsBinding
import jp.subgrow.android.sdk.data.usecases.subscriptions.SubscriptionsEffect.GoToOffer
import ru.egslava.subgrowandroiddemo.platform.ui.subscriptions.HomeViewModel

class SubscriptionsFragment : Fragment() {

    private var _binding: FragmentSubscriptionsBinding? =
        null
    private val binding get() = _binding!!
    private lateinit var adapter: SubscriptionsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val vm = ViewModelProvider(this)
            .get(HomeViewModel::class.java)

        _binding = FragmentSubscriptionsBinding
            .inflate(inflater, container, false)
        val root: View = binding.root

        // Set the adapter
        val list = binding.list
        list.layoutManager =
            LinearLayoutManager(context)
        adapter =
            SubscriptionsRecyclerViewAdapter(listOf()) {
                    token ->
                vm.buy(requireActivity(), token)
            }
        list.adapter = this.adapter

        vm.subs_items.observe(viewLifecycleOwner) {
            adapter.values = it ?: listOf()
            adapter.notifyDataSetChanged()
        }

        binding.btnCrash.setOnClickListener {
            vm.onBtnCrash()
        }

        vm.effects.observe(viewLifecycleOwner) {
            when (it) {
                is GoToOffer -> {
                    findNavController().navigate(
                        R.id.action_navigation_home_to_navigation_offer,
                        bundleOf("offer_arg_1" to it.offer)
                    )
                }
            }
        }

        vm.uid.observe(viewLifecycleOwner) {
            binding.userId.text =
                getString(R.string.user_id, it)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
