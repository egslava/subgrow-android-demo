package jp.subgrow.android.demo.platform.ui.subscriptions

import jp.subgrow.android.demo.platform.ui.subscriptions.Converter.expires_in_mmss
import jp.subgrow.android.sdk.data.entities.Offer
import org.junit.Test
import org.junit.Assert.assertEquals as eq

class ConverterTest {

    @Test
    fun toStrTest() {
        val offer = Offer(
            order = 1,
            title = "Title",
            duration = "100",
            duration_millis = 100,
            buttonText = "Buy now",
            purchase_time = 0,
        )


        eq("00:10",
            offer.copy(duration_millis = 10_000)
                .expires_in_mmss(0),
        )
        eq("00:20",
            offer.copy(duration_millis = 20_000)
                .expires_in_mmss(0),
        )
        eq("00:19",
            offer.copy(duration_millis = 20_000)
                .expires_in_mmss(1000),
        )
        eq("60:00",
            offer.copy(duration_millis = 60_000 * 60)
                .expires_in_mmss(0),
        )
        eq("180:00",
            offer.copy(
                duration_millis = 60_000 * 60 * 3
            ).expires_in_mmss(0),
        )
    }
}
