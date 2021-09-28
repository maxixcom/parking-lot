package parking.application.interactor

import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.SpotByReg

class SpotByRegImpl(
    private val parkingLotGateway: ParkingLotGateway
) : SpotByReg {
    override fun execute(request: SpotByReg.Request): SpotByReg.Response {
        val result = kotlin.runCatching {
            parkingLotGateway.findSpotByCarRegNumber(request.regNumber)
                .map { it.id }
        }
        return SpotByReg.Response(result)
    }
}
