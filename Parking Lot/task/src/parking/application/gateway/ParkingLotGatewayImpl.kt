package parking.application.gateway

import parking.domain.entity.Car
import parking.domain.entity.Spot
import parking.domain.exception.NotCreatedException
import parking.domain.gateway.ParkingLotGateway
import parking.persistence.ParkingLotRegistry

class ParkingLotGatewayImpl(
    private val parkingLotRegistry: ParkingLotRegistry
) : ParkingLotGateway {
    private fun getParkingLot() = parkingLotRegistry.get() ?: throw NotCreatedException()

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
        return getParkingLot().spots.firstOrNull { it.id == id }
    }

    override fun findEmptySpot(): Spot? {
        return getParkingLot().spots.firstOrNull { it.car == null }
    }

    override fun findBusySpots(): List<Spot> {
        return getParkingLot().spots.filter { it.car != null }.sortedBy { it.id }
    }

    override fun findSpotByCarColor(color: String): List<Spot> {
        return getParkingLot().spots
            .filter { spot ->
                spot.car?.let { car ->
                    car.color.lowercase() == color.lowercase()
                } ?: false
            }
            .sortedBy { it.id }
    }

    override fun findSpotByCarRegNumber(regNumber: String): List<Spot> {
        return getParkingLot().spots
            .filter { spot ->
                spot.car?.let { car ->
                    car.regNumber == regNumber
                } ?: false
            }
            .sortedBy { it.id }
    }
}
