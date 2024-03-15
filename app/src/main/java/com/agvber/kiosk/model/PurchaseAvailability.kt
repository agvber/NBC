package com.agvber.kiosk.model

sealed interface PurchaseAvailability {

    object Available: PurchaseAvailability

    object Unavailable: PurchaseAvailability
}