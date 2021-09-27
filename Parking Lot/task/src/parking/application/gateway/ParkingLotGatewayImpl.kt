package parking.application.gateway

import parking.domain.entity.Car
import parking.domain.entity.Spot
import parking.domain.exception.NotCreatedException
import parking.domain.gateway.ParkingLotGateway
import parking.persistence.ParkingLotRegistry

class ParkingLotGatewayImpl(
    private val parkingLotRegistry: ParkingLotRegistry
) : ParkingLotGateway {
    override fun park(car: Car, spot: Spot): Spot {
        spot.car = car
        return spot
    }

    override fun leave(spot: Spot): Car? {
        val car = spot.car
        spot.car = null
        return car
    }

    override fun findSpotById(id: Int): Spot? {
        val parkingLot = parkingLotRegistry.get() ?: throw NotCreatedException()
        return parkingLot.spots.firstOrNull { it.id == id }
    }

    override fun findEmptySpot(): Spot? {
        val parkingLot = parkingLotRegistry.get() ?: throw NotCreatedException()
        return parkingLot.spots.firstOrNull { it.car == null }
    }

    override fun findBusySpots(): List<Spot> {
        val parkingLot = parkingLotRegistry.get() ?: throw NotCreatedException()
        return parkingLot.spots.filter { it.car != null }.sortedBy { it.id }
    }
}
