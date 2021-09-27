package parking.persistence

import parking.domain.entity.ParkingLot

class ParkingLotRegistryImpl(capacity: Int) : ParkingLotRegistry {
    private val parkingLot = ParkingLot(capacity)

    override fun get() = parkingLot
}
