package parking.application.interactor

import parking.domain.entity.Car
import parking.domain.exception.NoEmptySpotException
import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.ParkCar

class ParkCarImpl(
    private val parkingLotGateway: ParkingLotGateway
) : ParkCar {
    override fun execute(request: ParkCar.Request): ParkCar.Response {
        val result = kotlin.runCatching {
            parkingLotGateway.findEmptySpot()?.let { spot ->
                spot.car = with(request) {
                    Car(
                        regNumber = regNumber,
                        color = color
                    )
                }
                spot
            } ?: throw NoEmptySpotException("No empty space on the parking lot")
        }
        return ParkCar.Response(result)
    }
}
