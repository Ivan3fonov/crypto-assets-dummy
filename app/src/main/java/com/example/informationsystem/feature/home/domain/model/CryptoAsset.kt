package com.example.informationsystem.feature.home.domain.model

import java.math.BigDecimal

data class CryptoAsset(
    val symbol: String,                         //"symbol":"ETHBTC",
    val priceChange: BigDecimal,            //"priceChange":"-0.00057000",
    val priceChangePercent: BigDecimal,     //"priceChangePercent":"-1.066",
    val weightedAvgPrice: BigDecimal,       //"weightedAvgPrice":"0.05289369",
    val prevClosePrice: BigDecimal,         //"prevClosePrice":"0.05345000",
    val lastPrice: BigDecimal,              //"lastPrice":"0.05289000",
    val lastQty: BigDecimal,                //"lastQty":"0.02460000",
    val bidPrice: BigDecimal,               //"bidPrice":"0.05288000",
    val bidQty: BigDecimal,                 //"bidQty":"13.65000000",
    val askPrice: BigDecimal,               //"askPrice":"0.05289000",
    val askQty: BigDecimal,                 //"askQty":"24.07940000",
    val openPrice: BigDecimal,              //"openPrice":"0.05346000",
    val highPrice: BigDecimal,              //"highPrice":"0.05351000",
    val lowPrice: BigDecimal,               //"lowPrice":"0.05249000",
    val volume: BigDecimal,                 //"volume":"24746.19490000",
    val quoteVolume: BigDecimal,            //"quoteVolume":"1308.91753604",
    val openTime: Long,                         //"openTime":1720186060105,
    val closeTime: Long,                        //"closeTime":1720272460105,
    val firstId: Long,                          //"firstId":453318440,
    val lastId: Long,                           //"lastId":453523980,
    val count: Int
)
