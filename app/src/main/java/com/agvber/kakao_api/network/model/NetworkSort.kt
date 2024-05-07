package com.agvber.kakao_api.network.model

import com.agvber.kakao_api.domain.model.Sort

enum class NetworkSort {
    ACCURACY, RECENCY
}

internal fun Sort.asNetworkModel(): NetworkSort =
    when (this) {
        Sort.ACCURACY -> NetworkSort.ACCURACY
        Sort.RECENCY -> NetworkSort.RECENCY
    }


internal fun NetworkSort.asExternalBodyString() =
    when (this) {
        NetworkSort.ACCURACY -> "accuracy"
        NetworkSort.RECENCY -> "recency"
    }