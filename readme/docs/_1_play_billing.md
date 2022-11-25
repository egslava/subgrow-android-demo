Subgrow Android Billing
=======================

# Common pit falls

1. You can't know what `base plan` you're subscribed
   on ([stackoverflow](https://stackoverflow.com/a/72673387))
1. You can't cancel subscriptions automatically — only
   via Google Play
   interface ([stackoverflow](https://stackoverflow.com/a/33260536))

It means that we can't know in the app if we should
stop subscription in 3/5/etc minutes, because we can't
know the time. The workaround is to have different
subscriptions for each offer (see the link above)

## API replays

# 1. queryProductDetails("com.b2s.subscription.oneyear4")

We use `offerTags` to distinguish between offers.
```json
{
   "productId": "com.b2s.subscription.oneyear4",
   "type": "subs",
   "title": "Demo Subscription - One Year 4 (Subgrow Android Demo)",
   "name": "Demo Subscription - One Year 4",
   "localizedIn": [
      "en-GB"
   ],
   "skuDetailsToken": "AEuhp4Jlyr3Nrlge1uyNON0hdbfv4vmu2NZNRgMbMXAuCwGCeo2lJFB13FtJ4tPbNm8G",
   "subscriptionOfferDetails": [
      {
         "offerIdToken": "AUj\/YhjqgKZJHmVYdzJGLbquQDxEv4gx\/dFtyO6Whqs1h+uuIoC8njLV9fGDPMNAyT\/NCaCBAb9n6x8W\/esmbWNDga55hQGuNzKLI4eoahzuvfht95fSwbJWDKpK0ukXfrecn0NYKAEh1p54ClfTrZutRg==",
         "pricingPhases": [
            {
               "priceAmountMicros": 399000000,
               "priceCurrencyCode": "RUB",
               "formattedPrice": "RUB 399.00",
               "billingPeriod": "P1Y",
               "recurrenceMode": 1
            }
         ],
         "offerTags": [
            "oneyear"
         ]
      }
   ]
}

```

## queryProductDetails("demo_subscription")
```json
{
   "productId": "demo_subscription",
   "type": "subs",
   "title": "A test subscribable product in Google Play (Subgrow Android Demo)",
   "name": "A test subscribable product in Google Play",
   "localizedIn": [
      "en-GB"
   ],
   "skuDetailsToken": "AEuhp4JcRGk9fNv_AJnJ8p4GcNc-bMU-DksSTbVeCyce-csz4rtT4iL4_oPs8D9M1o4=",
   "subscriptionOfferDetails": [
      {
         "offerIdToken": "AUj\/YhjA3+yp+Q8OWZPlIppJg9tF5Ayk2kDOtQkehUyUvUc8YyMRPM82q6DMqE4yB+2W+mnDri3ZlMCPbiBVeOoKmwSaYd9TWAnDfmLvxmx3+\/zMEZh6irbPrPwboVBkNZxAqobrBvnpALtdpWvySBK+oQ==",
         "pricingPhases": [
            {
               "priceAmountMicros": 45000000,
               "priceCurrencyCode": "RUB",
               "formattedPrice": "RUB 45.00",
               "billingPeriod": "P1M",
               "recurrenceMode": 1
            }
         ],
         "offerTags": [
            "onemonth"
         ]
      },
      {
         "offerIdToken": "AUj\/YhiA8YxXcdhj\/NbpKNKKupjfXKkn7cbJVLtg8hzXOFRf\/6sSj71yax7ZDmOAo29GfSM7NtaeDB32kVuatK4YBBfgPHM9iHL3+gDV5A\/T4zbQZH6YPLt\/dAWlP4j3f7wfaLkZMF7wxER5h9YxGtbhZA==",
         "pricingPhases": [
            {
               "priceAmountMicros": 399000000,
               "priceCurrencyCode": "RUB",
               "formattedPrice": "RUB 399.00",
               "billingPeriod": "P1Y",
               "recurrenceMode": 1
            }
         ],
         "offerTags": [
            "oneyear"
         ]
      },
      {
         "offerIdToken": "AUj\/YhjmFdYRPbd6eMP5e3JtIBjK30GxSPiH5V13Arw7AYy4iZalFcNMrFJqDdjJWPiXLN8uIkLoVqBI8oGdpbqILYFtLKfiA8eZnUkMwAmP+wDVLIoXfzxwAOm5cKD\/aM8Vd3Bj+WCMujN8N9NI4Fx6Ng==",
         "pricingPhases": [
            {
               "priceAmountMicros": 239000000,
               "priceCurrencyCode": "RUB",
               "formattedPrice": "RUB 239.00",
               "billingPeriod": "P6M",
               "recurrenceMode": 1
            }
         ],
         "offerTags": [
            "sixmonth"
         ]
      },
      {
         "offerIdToken": "AUj\/YhhkWBmB7VrXg+vFupl0p\/i3R0TdhdfsK6XhAQj06pRHbEfgM3JqVUU8US36t22q434UcUQQnhP5M5wZ9850Qt7naNaLP9KEMuXEkHxq\/0SdlKKdnynRvBZDd7RK8enYBXaOH7mqZpC3aI3B\/hJ8mzw0t2c=",
         "pricingPhases": [
            {
               "priceAmountMicros": 119000000,
               "priceCurrencyCode": "RUB",
               "formattedPrice": "RUB 119.00",
               "billingPeriod": "P3M",
               "recurrenceMode": 1
            }
         ],
         "offerTags": [
            "threemonth"
         ]
      }
   ]
}
```

# 2. on purchase (update listener):

## new on purchase (onemonth):
Response Code: OK, Debug Message: 
```json
[
   {
      "orderId": "GPA.3309-4787-6342-13053",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "com.b2s.subscription.onemonth3",
      "purchaseTime": 1659042891626,
      "purchaseState": 0,
      "purchaseToken": "njoiffhpaoglnmiipneeppfp.AO-J1OyYvod-KlL7VpAZGCiZ7U1l1LHZQNBcaIQvtDdyvQygcvCc79oeYYzDkHrLoHmZ5JQVj_V_hrjgYYW6pkVLoUd0ADmQe4uHnl_6vvCjFCZkTCgDfjc",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```
## normal

```json
[
   {
      "orderId": "GPA.3302-6575-1669-43809",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "demo_subscription",
      "purchaseTime": 1658179618288,
      "purchaseState": 0,
      "purchaseToken": "impggafpdadhecijokkkbhko.AO-J1OzJ5oi8TwsMgv2TE0Evrl3rjzItrIb0Eg4QAusSRkK1SrwzJiT1dTVDLxXX93H9tpPRB5q-DTPdrEjP9VZHjDFJWN5xgN-EmGzxNTrCA0MZuCQCVfg",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

```json
[
   {
      "orderId": "GPA.3343-7865-2747-16166",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "demo_subscription",
      "purchaseTime": 1658180179128,
      "purchaseState": 0,
      "purchaseToken": "gilnimmkhopeidbdlcjojepf.AO-J1OxMiuJsbljTERmUprz9af3V2jKwRlOtDksfd6aOkOftVYruEz6cfRosjtScu1Ay1GtRp42f9bfS-tgW6t0eGgYq6X9BRPm7zb9kxJIfSNTst-jTd5A",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

## already purchased:

D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: ITEM_ALREADY_OWNED,
Debug Message:
D/subgrow_billing: null

# 3. queryPurchases

Purchases loaded (now: 1658349604635:
Response Code: OK, Debug Message:

## there are active subscriptions

D/subgrow_billing:

### old
```json
[
   {
      "orderId": "GPA.3384-0897-9575-39213",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "demo_subscription",
      "purchaseTime": 1658349440288,
      "purchaseState": 0,
      "purchaseToken": "namoalghkbihijbcmoimfjmj.AO-J1OxhxJlyxl4SPCZcFCkzSdJb_u9mbXrWbEJkd1a-MZ8Pb6KFmbhKbyfpP-DzQMeFogxFsgu7dI1CQoHoyiphn0tMTyrfIaeukB56kA4JZFzz8XvUqqc",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

### new 
Purchases loaded (now: 1659043025308:
2022-07-29 00:17:05.317 20685-20805/ru.egslava.subgrowandroiddemo D/subgrow_billing: Response Code: OK, Debug Message: 
```json
[
   {
      "orderId": "GPA.3309-4787-6342-13053",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "com.b2s.subscription.onemonth3",
      "purchaseTime": 1659042891626,
      "purchaseState": 0,
      "purchaseToken": "njoiffhpaoglnmiipneeppfp.AO-J1OyYvod-KlL7VpAZGCiZ7U1l1LHZQNBcaIQvtDdyvQygcvCc79oeYYzDkHrLoHmZ5JQVj_V_hrjgYYW6pkVLoUd0ADmQe4uHnl_6vvCjFCZkTCgDfjc",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

## no subscriptions — empty list

Just an empty list

## no actives

# После покупки

D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
D/subgrow_billing: [Purchase. Json: {"orderId":"GPA.3383-4874-0377-12589","packageName":"ru.egslava.subgrowandroiddemo","productId":"demo_subscription","purchaseTime":1658412297989,"purchaseState":0,"purchaseToken":"gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM","quantity":1,"autoRenewing":true,"acknowledged":false}]
D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
D/subgrow_billing: [Purchase. Json: {"orderId":"GPA.3383-4874-0377-12589","packageName":"ru.egslava.subgrowandroiddemo","productId":"demo_subscription","purchaseTime":1658412297989,"purchaseState":0,"purchaseToken":"gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM","quantity":1,"autoRenewing":true,"acknowledged":false}]
D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
D/subgrow_billing: [Purchase. Json: {"orderId":"GPA.3383-4874-0377-12589","packageName":"ru.egslava.subgrowandroiddemo","productId":"demo_subscription","purchaseTime":1658412297989,"purchaseState":0,"purchaseToken":"gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM","quantity":1,"autoRenewing":true,"acknowledged":false}]

# Purchases history:

```json
[
   {
      "productId": "demo_subscription",
      "purchaseToken": "fbmgffgbcggfciknnkcampgc.AO-J1OwcbdJePQGeujrstwY8__6og800a7kcm_h8hdm_Jlwt22HR6FspYry45-Tbg1F4Ucba5SVNOJMyUOJ11-Cs8C_-apVqwFsgmejQ3vPfJ-J2kRBJzqs",
      "purchaseTime": 1658870269523,
      "quantity": 1,
      "developerPayload": null
   }
]

```

# После покупки

D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
D/subgrow_billing: [Purchase. Json:

```json

{
   "orderId": "GPA.3383-4874-0377-12589",
   "packageName": "ru.egslava.subgrowandroiddemo",
   "productId": "demo_subscription",
   "purchaseTime": 1658412297989,
   "purchaseState": 0,
   "purchaseToken": "gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM",
   "quantity": 1,
   "autoRenewing": true,
   "acknowledged": false
}
```

]
D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
D/subgrow_billing: [Purchase. Json:

```json
{
   "orderId": "GPA.3383-4874-0377-12589",
   "packageName": "ru.egslava.subgrowandroiddemo",
   "productId": "demo_subscription",
   "purchaseTime": 1658412297989,
   "purchaseState": 0,
   "purchaseToken": "gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM",
   "quantity": 1,
   "autoRenewing": true,
   "acknowledged": false
}
```

]
D/subgrow_billing: logPurchasesUpdated
D/subgrow_billing: Response Code: OK, Debug Message:
Purchase. Json:

```json
[
   {
      "orderId": "GPA.3383-4874-0377-12589",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "demo_subscription",
      "purchaseTime": 1658412297989,
      "purchaseState": 0,
      "purchaseToken": "gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

# В след раз:

same Purchase. Json:

```json
[
   {
      "orderId": "GPA.3383-4874-0377-12589",
      "packageName": "ru.egslava.subgrowandroiddemo",
      "productId": "demo_subscription",
      "purchaseTime": 1658412297989,
      "purchaseState": 0,
      "purchaseToken": "gafahbjiaephfchogimgelah.AO-J1OwItyZ02G7Cdv3Kyf-kSaCRX3eL_hDZKeIIkqVVa3ZRrYAp-aA-gXdamBwc_D2xDZ0dVbhh9XTezpgMtsgTDcTpu4bKra2bbTuqwzAmshJ_vo05-BM",
      "quantity": 1,
      "autoRenewing": true,
      "acknowledged": false
   }
]
```

