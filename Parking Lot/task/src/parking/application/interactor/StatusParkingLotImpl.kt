package parking.application.interactor

import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.StatusParkingLot

class StatusParkingLotImpl(
    private val parkingLotGateway: ParkingLotGateway
) : StatusParkingLot {
    override fun execute(): StatusParkingLot.Response {
        val result = kotlin.runCatching {
            parkingLotGateway.findBusySpots()
        }
        return StatusParkingLot.Response(result)
    }
}
