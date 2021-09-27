package parking.domain.entity

class ParkingLot(capacity: Int) {
    //    val spots = List(capacity) { Spot(it + 1) }
    // TODO: for this step we have predefined spots
    val spots = listOf(
        Spot(1, Car(regNumber = "XXX", "Black")),
        Spot(2)
    )
}
