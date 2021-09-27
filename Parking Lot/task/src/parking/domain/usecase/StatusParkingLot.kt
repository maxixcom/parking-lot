package parking.domain.usecase

import parking.domain.entity.Spot

interface StatusParkingLot {
    fun execute(): Response
    data class Response(val result: Result<List<Spot>>)
}
