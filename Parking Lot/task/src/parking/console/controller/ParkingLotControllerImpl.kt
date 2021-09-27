package parking.console.controller

import parking.console.command.CommandLeave
import parking.console.command.CommandPark
import parking.domain.exception.NoCarException
import parking.domain.exception.NoEmptySpotException
import parking.domain.exception.SpotNotFoundException
import parking.domain.usecase.LeaveSpot
import parking.domain.usecase.ParkCar

class ParkingLotControllerImpl(
    val parkCar: ParkCar,
    val leaveSpot: LeaveSpot
) : ParkingLotController {
    override fun parkCar(command: CommandPark) {
        val response = parkCar.execute(
            ParkCar.Request(
                regNumber = command.regNumber,
                color = command.color
            )
        )
        response.result.fold(
            {
                println("${it.car!!.color} car parked in spot ${it.id}.")
            },
            {
                when (it) {
                    is NoEmptySpotException -> println(it.message)
                    is Exception -> println("(!) Unknown error - ${it.message}")
                }
            }
        )
    }

    override fun leaveSpot(command: CommandLeave) {
        val response = leaveSpot.execute(
            LeaveSpot.Request(
                spotId = command.spotId,
            )
        )
        response.result.fold(
            {
                println("Spot ${command.spotId} is free.")
            },
            {
                when (it) {
                    is SpotNotFoundException -> println(it.message)
                    is NoCarException -> println(it.message)
                    is Exception -> println("(!) Unknown error - ${it.message}")
                }
            }
        )
    }
}
