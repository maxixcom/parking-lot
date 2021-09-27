package parking.domain.entity

class ParkingLot(capacity: Int) {
    val spots = List(capacity) { Spot(it + 1) }
}
