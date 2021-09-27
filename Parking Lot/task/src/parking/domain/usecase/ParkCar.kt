package parking.domain.usecase

import parking.domain.entity.Spot

interface ParkCar {
    fun execute(request: Request): Response

    data class Request(val regNumber: String, val color: String)
    data class Response(val result: Result<Spot>)
}
