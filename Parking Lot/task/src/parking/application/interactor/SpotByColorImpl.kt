package parking.application.interactor

import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.SpotByColor

class SpotByColorImpl(
    private val parkingLotGateway: ParkingLotGateway
) : SpotByColor {
    override fun execute(request: SpotByColor.Request): SpotByColor.Response {
        val result = kotlin.runCatching {
            parkingLotGateway.findSpotByCarColor(request.color)
                .map { it.id }
        }
        return SpotByColor.Response(result)
    }
}
