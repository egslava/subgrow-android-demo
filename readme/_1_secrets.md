# Welcome!

1. You're encouraged not to sign builds locally. Though it can be handy (
   temporary) for debugging ci/cd local debugging.
2. If you just want to debug the release build 
   itself, please, use `debug_config` signing config.
3. Releases are created automatically when there's a merge into `master` branch.

# Set up a new repo:

1. In the wallet (or ping egslava)
   there's `bogunov-android-demo-keystore`.
2. copy-paste `base64 bogunov-android-demo-keystore`
   into `secrets` sections of your ci/cd
   as `BOGUNOV_EGSLAVA_DEMO_STORE_BASE64`
   environment variable.
3. Also, fill in `BOGUNOV_EGSLAVA_DEMO_KEY_ALIAS`,
   `BOGUNOV_EGSLAVA_DEMO_KEY_PASSWORD` and
   `BOGUNOV_EGSLAVA_DEMO_STORE_PASSWORD` variables.
4. Set `ANDROID_PUBLISHER_CREDENTIALS` environment
   variable to be able to upload builds to PlayStore
   automatically.

# Register new Firebase project

1. Create a new [Firebase project](https://console.
   firebase.google.com/)
2. Follow the guide to integrate it with Android
3. Also follow
   official [Android integration guide](https://firebase.google.com/docs/cloud-messaging/android/client)
4. Add [crashlytics](https://console.firebase.google.com/project/ru-egslava-subgrowandroiddemo/crashlytics/app/android:ru.egslava.subgrowandroiddemo/issues) 
