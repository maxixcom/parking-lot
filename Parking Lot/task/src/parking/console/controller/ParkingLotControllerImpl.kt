package parking.console.controller

import parking.console.command.CommandCreate
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
import parking.console.command.CommandRegByColor
import parking.console.command.CommandSpotByColor
import parking.console.command.CommandSpotByReg
import parking.console.command.CommandStatus
import parking.domain.usecase.CreateParkingLot
import parking.domain.usecase.LeaveSpot
import parking.domain.usecase.ParkCar
import parking.domain.usecase.RegByColor
import parking.domain.usecase.SpotByColor
import parking.domain.usecase.SpotByReg
import parking.domain.usecase.StatusParkingLot

class ParkingLotControllerImpl(
    val parkCar: ParkCar,
    val leaveSpot: LeaveSpot,
    val createParkingLot: CreateParkingLot,
    val statusParkingLot: StatusParkingLot,
    val regByColor: RegByColor,
    val spotByColor: SpotByColor,
    val spotByReg: SpotByReg,
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

    override fun create(command: CommandCreate) {
        val response = createParkingLot.execute(
            CreateParkingLot.Request(
                capacity = command.capacity
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

    override fun status(command: CommandStatus) {
        val response = statusParkingLot.execute()
        response.result.fold(
            { list ->
                if (list.isEmpty()) {
                    println("Parking lot is empty.")
                } else {
                    list.forEach { spot ->
                        spot.car?.let { car ->
                            println("${spot.id} ${car.regNumber} ${car.color}")
                        }
                    }
                }
            },
            {
                println(it.message)
            }
        )
    }

    override fun regByColor(command: CommandRegByColor) {
        val response = regByColor.execute(
            RegByColor.Request(
                color = command.color
            )
        )
        response.result.fold(
            { list ->
                if (list.isEmpty()) {
                    println("No cars with color ${command.color.uppercase()} were found.")
                } else {
                    println(list.joinToString(", "))
                }
            },
            {
                println(it.message)
            }
        )
    }

    override fun spotByColor(command: CommandSpotByColor) {
        val response = spotByColor.execute(
            SpotByColor.Request(
                color = command.color
            )
        )
        response.result.fold(
            { list ->
                if (list.isEmpty()) {
                    println("No cars with color ${command.color.uppercase()} were found.")
                } else {
                    println(list.joinToString(", "))
                }
            },
            {
                println(it.message)
            }
        )
    }

    override fun spotByReg(command: CommandSpotByReg) {
        val response = spotByReg.execute(
            SpotByReg.Request(
                regNumber = command.regNumber
            )
        )
        response.result.fold(
            { list ->
                if (list.isEmpty()) {
                    println("No cars with registration number ${command.regNumber} were found.")
                } else {
                    println(list.joinToString(", "))
                }
            },
            {
                println(it.message)
            }
        )
    }
}
