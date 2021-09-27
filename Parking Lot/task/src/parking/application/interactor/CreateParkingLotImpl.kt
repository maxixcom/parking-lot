package parking.application.interactor

import parking.domain.usecase.CreateParkingLot
import parking.persistence.ParkingLotRegistry

class CreateParkingLotImpl(
    private val parkingLotRegistry: ParkingLotRegistry
) : CreateParkingLot {
    override fun execute(request: CreateParkingLot.Request): CreateParkingLot.Response {
        val result = kotlin.runCatching {
            parkingLotRegistry.create(request.capacity)
            parkingLotRegistry.get()!!
        }
        return CreateParkingLot.Response(result)
    }
}
