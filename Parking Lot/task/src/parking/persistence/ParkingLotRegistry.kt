package parking.persistence

import parking.domain.entity.ParkingLot

interface ParkingLotRegistry {
    fun get(): ParkingLot
}
