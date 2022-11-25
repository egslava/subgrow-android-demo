package jp.subgrow.android.demo.platform.services

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import jp.subgrow.android.sdk.B2S



class SubgrowFirebaseMessagingService :
    FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        B2S.gotPushViaService(message.data)
    }
}
