package jp.subgrow.android.demo.platform.ui.subscriptions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.subgrow.android.demo.databinding.FragmentSubscriptionsItemBinding

class SubscriptionsRecyclerViewAdapter(
    var values: List<SubscriptionItem>,
    val onClicklistener: (token: String) -> Unit,
) : RecyclerView.Adapter<SubscriptionsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val holder = ViewHolder(
            FragmentSubscriptionsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        holder.button.setOnClickListener{
            onClicklistener(it.tag as String)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.duration.text = item.time_subtitle
        holder.button.text = item.price_button
        holder.button.tag = item.token
        holder.button.isEnabled = !item.is_price_button_disabled

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSubscriptionsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.subscriptionItemTitle
        val duration: TextView = binding.subscriptionItemDuration
        val button: Button = binding.subscriptionItemBtn

        override fun toString() = "${super.toString()} '${duration.text}'"
    }
}
