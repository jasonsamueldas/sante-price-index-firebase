package com.example.santepricev2

import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

data class MandiPrice(
    val commodity: String = "",
    val market: String = "",
    val state: String = "",
    val minPrice: Double = 0.0,
    val maxPrice: Double = 0.0,
    val modalPrice: Double = 0.0,
    val arrivalDate: String = ""
)

data class PriceState(
    val prices: List<MandiPrice> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val lastUpdated: String? = null,
    val isOffline: Boolean = false
)

object PriceRepository {

    private val db =
        FirebaseDatabase.getInstance().reference

    suspend fun fetchPrices(
        commodity: String,
        limit: Int = 10
    ): Result<List<MandiPrice>> {

        return try {

            val snapshot = db
                .child("mandi_prices")
                .child(commodity)
                .get()
                .await()

            val prices = mutableListOf<MandiPrice>()

            snapshot.children.forEach { child ->

                val item =
                    child.value as? Map<*, *>

                if (item != null) {

                    prices.add(
                        MandiPrice(
                            commodity =
                                item["commodity"] as? String ?: "",

                            market =
                                item["market"] as? String ?: "",

                            state =
                                item["state"] as? String ?: "",

                            minPrice =
                                (item["minPrice"] as? Number)
                                    ?.toDouble() ?: 0.0,

                            maxPrice =
                                (item["maxPrice"] as? Number)
                                    ?.toDouble() ?: 0.0,

                            modalPrice =
                                (item["modalPrice"] as? Number)
                                    ?.toDouble() ?: 0.0,

                            arrivalDate =
                                item["arrivalDate"] as? String ?: ""
                        )
                    )
                }
            }

            val sorted =
                prices.sortedByDescending {
                    it.arrivalDate
                }.take(limit)

            Result.success(sorted)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }

    suspend fun fetchCommodityNames():
            Result<List<String>> {

        return try {

            val snapshot = db
                .child("mandi_prices")
                .get()
                .await()

            val commodities =
                snapshot.children.mapNotNull {
                    it.key
                }.sorted()

            Result.success(commodities)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}