package ru.egslava.subgrowandroiddemo.platform.ui.subscriptions

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import jp.subgrow.android.demo.platform.LiveEvent
import jp.subgrow.android.demo.platform.ui.subscriptions.Converter.toSubscriptionItems
import jp.subgrow.android.demo.platform.ui.subscriptions.SubscriptionItem
import jp.subgrow.android.demo.platform.utils.Ticker.ticker
import jp.subgrow.android.sdk.B2S
import jp.subgrow.android.sdk.data.usecases.subscriptions.PushesEffect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel(
    app: Application,
) : AndroidViewModel(app) {

    val subs_items: LiveData<List<SubscriptionItem>>
    val effects = LiveEvent<PushesEffect>()

    val uid = B2S.uid.asLiveData()

    fun buy(activity: Activity, token: String) {
        B2S.buy(activity, token)
    }

    init {
        B2S.loadPlaySubscriptions(app,
            "7ea57fec-ed9d-4fb9-8f24-51947fe25066",
            arrayOf(
                "com.b2s.subscription.oneweek",
//                "com.b2s.subscription.oneweek2",
//                "com.b2s.subscription.4weeks",
                "com.b2s.subscription.onemonth3",
                "com.b2s.subscription.threemonth3",
                "com.b2s.subscription.sixmonth3",
                "com.b2s.subscription.oneyear4",
            ))

        viewModelScope.launch {
            B2S.onOfferReceived
                .collect(effects::postValue)
        }

        subs_items = combine(
            B2S.playSubscriptions,
            viewModelScope.ticker(500),
        ) { subscriptions, _ ->
            subscriptions.toSubscriptionItems()
        }.asLiveData()
    }


    fun onBtnCrash() {
        throw RuntimeException("""
            A user decided to crash the app
        """.trimIndent())
    }
}
