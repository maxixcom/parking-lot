package parking.persistence

import parking.domain.entity.ParkingLot

interface ParkingLotRegistry {
    fun create(capacity: Int)
    fun get(): ParkingLot?
}
