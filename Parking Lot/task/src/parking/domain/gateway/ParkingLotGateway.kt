package parking.domain.gateway

import parking.domain.entity.Car
import parking.domain.entity.Spot

interface ParkingLotGateway {
    fun park(car: Car, spot: Spot): Spot
    fun leave(spot: Spot): Car?
    fun findSpotById(id: Int): Spot?
    fun findEmptySpot(): Spot?
    fun findBusySpots(): List<Spot>

    fun findSpotByCarColor(color: String): List<Spot>
    fun findSpotByCarRegNumber(regNumber: String): List<Spot>
}
