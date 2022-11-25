package jp.subgrow.android.demo.platform.ui.subscriptions

import jp.subgrow.android.sdk.data.entities.Offer

class SubscriptionItem(
    val title: String,
    val time_subtitle: String,
    val price_button: String,
    val is_price_button_disabled: Boolean,
    val token: String = "",
)

fun Offer.toSubscriptionItem(
    /** Expiration time in format "00:57" or null */
    time_title: String?
): SubscriptionItem {
    val subscription = this
    return SubscriptionItem(
        title = subscription.title,
        time_subtitle = subscription.duration,
        price_button = time_title
            ?: subscription.buttonText,
        is_price_button_disabled = (time_title != null),
        token = subscription.token
    )
}
