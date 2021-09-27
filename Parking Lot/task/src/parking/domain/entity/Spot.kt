package parking.domain.entity

data class Spot(
    val id: Int,
    var car: Car? = null,
)
