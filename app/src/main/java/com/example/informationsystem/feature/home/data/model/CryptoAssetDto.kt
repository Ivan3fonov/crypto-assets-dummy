package com.example.informationsystem.feature.home.data.model

import com.example.informationsystem.core_network.serializer.BigDecimalJson
import kotlinx.serialization.Serializable

@Serializable
data class CryptoAssetDto(
    val symbol: String,                         //"symbol":"ETHBTC",
    val priceChange: BigDecimalJson,            //"priceChange":"-0.00057000",
    val priceChangePercent: BigDecimalJson,     //"priceChangePercent":"-1.066",
    val weightedAvgPrice: BigDecimalJson,       //"weightedAvgPrice":"0.05289369",
    val prevClosePrice: BigDecimalJson,         //"prevClosePrice":"0.05345000",
    val lastPrice: BigDecimalJson,              //"lastPrice":"0.05289000",
    val lastQty: BigDecimalJson,                //"lastQty":"0.02460000",
    val bidPrice: BigDecimalJson,               //"bidPrice":"0.05288000",
    val bidQty: BigDecimalJson,                 //"bidQty":"13.65000000",
    val askPrice: BigDecimalJson,               //"askPrice":"0.05289000",
    val askQty: BigDecimalJson,                 //"askQty":"24.07940000",
    val openPrice: BigDecimalJson,              //"openPrice":"0.05346000",
    val highPrice: BigDecimalJson,              //"highPrice":"0.05351000",
    val lowPrice: BigDecimalJson,               //"lowPrice":"0.05249000",
    val volume: BigDecimalJson,                 //"volume":"24746.19490000",
    val quoteVolume: BigDecimalJson,            //"quoteVolume":"1308.91753604",
    val openTime: Long,                         //"openTime":1720186060105,
    val closeTime: Long,                        //"closeTime":1720272460105,
    val firstId: Long,                          //"firstId":453318440,
    val lastId: Long,                           //"lastId":453523980,
    val count: Int                              //"count":205541
)