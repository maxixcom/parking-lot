package parking.application.interactor

import parking.domain.exception.NoCarException
import parking.domain.exception.SpotNotFoundException
import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.LeaveSpot

class LeaveSpotImpl(
    private val parkingLotGateway: ParkingLotGateway
) : LeaveSpot {
    override fun execute(request: LeaveSpot.Request): LeaveSpot.Response {
        val result = kotlin.runCatching {
            val spot = parkingLotGateway.findSpotById(request.spotId)
                ?: throw SpotNotFoundException("Spot ${request.spotId} is not found on the parking lot")
            spot.car ?: throw NoCarException("There is no car in spot ${request.spotId}.")

            parkingLotGateway.leave(spot)!!
        }
        return LeaveSpot.Response(result)
    }
}
