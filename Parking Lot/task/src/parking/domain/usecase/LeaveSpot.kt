package parking.domain.usecase

import parking.domain.entity.Car

interface LeaveSpot {
    fun execute(request: Request): Response

    data class Request(val spotId: Int)
    data class Response(val result: Result<Car>)
}
