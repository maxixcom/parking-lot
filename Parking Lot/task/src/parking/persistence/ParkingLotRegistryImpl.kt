package parking.persistence

import parking.domain.entity.ParkingLot

class ParkingLotRegistryImpl : ParkingLotRegistry {
    private var instance: ParkingLot? = null

    override fun create(capacity: Int) {
        this.instance = ParkingLot(capacity)
    }

    override fun get() = instance
}
