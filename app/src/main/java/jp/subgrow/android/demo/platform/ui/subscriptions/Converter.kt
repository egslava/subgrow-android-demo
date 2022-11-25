package jp.subgrow.android.demo.platform.ui.subscriptions

import jp.subgrow.android.sdk.data.entities.Offer

object Converter {
    /** "00:09" until offer's expiration */
    fun Offer?.expires_in_mmss(
        now: Long = System.currentTimeMillis(),
    ): String? {
        val offer = this ?: return null

        val seconds_till = (
            offer.purchase_time + offer.duration_millis
                - now) / 1000

        if (seconds_till <= 0)
            return null

        val mm = seconds_till / 60
        val ss = seconds_till % 60

        return "%02d:%02d".format(mm, ss)
    }

    fun List<Offer>.toSubscriptionItems(): List<SubscriptionItem> {
        val subscriptions = this

        val last = subscriptions.firstOrNull {
            it.purchase_time != 0L
        }

        val time_title = last.expires_in_mmss()

        return subscriptions.map {
            it.toSubscriptionItem(time_title)
        }
    }
}
