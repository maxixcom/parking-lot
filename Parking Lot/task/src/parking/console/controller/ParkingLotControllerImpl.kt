package parking.console.controller

import parking.console.command.CommandCreate
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
import parking.domain.usecase.CreateParkingLot
import parking.domain.usecase.LeaveSpot
import parking.domain.usecase.ParkCar

class ParkingLotControllerImpl(
    val parkCar: ParkCar,
    val leaveSpot: LeaveSpot,
    val createParkingLot: CreateParkingLot,
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
                println(it.message)
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
                println(it.message)
            }
        )
    }

    override fun create(commandCreate: CommandCreate) {
        val response = createParkingLot.execute(
            CreateParkingLot.Request(
                capacity = commandCreate.capacity
            )
        )
        response.result.fold(
            {
                println("Created a parking lot with ${it.spots.size} spots.")
            },
            {
                println(it.message)
            }
        )
    }
}
