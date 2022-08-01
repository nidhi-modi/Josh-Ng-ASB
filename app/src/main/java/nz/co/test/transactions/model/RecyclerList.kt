package nz.co.test.transactions.model

import java.math.BigDecimal
import java.time.OffsetDateTime

data class RecyclerList(val items: List<RecyclerData>)
data class RecyclerData(
    val id: Int?,
    val transactionDate: OffsetDateTime?,
    val summary: String?,
    val debit: BigDecimal?,
    val credit: BigDecimal?
)
