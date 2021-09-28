package parking.application.interactor

import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.RegByColor

class RegByColorImpl(
    private val parkingLotGateway: ParkingLotGateway
) : RegByColor {
    override fun execute(request: RegByColor.Request): RegByColor.Response {
        val result = kotlin.runCatching {
            parkingLotGateway.findSpotByCarColor(request.color)
                .map { it.car!!.regNumber }
        }
        return RegByColor.Response(result)
    }
}
