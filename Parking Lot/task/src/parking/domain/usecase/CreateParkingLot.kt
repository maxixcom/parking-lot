package parking.domain.usecase

import parking.domain.entity.ParkingLot

interface CreateParkingLot {
    fun execute(request: Request): Response

    data class Request(val capacity: Int)
    data class Response(val result: Result<ParkingLot>)
}
