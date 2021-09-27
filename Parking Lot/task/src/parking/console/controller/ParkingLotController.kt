package parking.console.controller

import parking.console.command.CommandCreate
import parking.console.command.CommandLeave
import parking.console.command.CommandPark

interface ParkingLotController {
    fun parkCar(command: CommandPark)
    fun leaveSpot(command: CommandLeave)
    fun create(commandCreate: CommandCreate)
}
