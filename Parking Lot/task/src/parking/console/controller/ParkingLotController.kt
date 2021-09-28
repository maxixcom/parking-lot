package parking.console.controller

import parking.console.command.CommandCreate
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
import parking.console.command.CommandRegByColor
import parking.console.command.CommandSpotByColor
import parking.console.command.CommandSpotByReg
import parking.console.command.CommandStatus

interface ParkingLotController {
    fun parkCar(command: CommandPark)
    fun leaveSpot(command: CommandLeave)
    fun create(command: CommandCreate)
    fun status(command: CommandStatus)
    fun regByColor(command: CommandRegByColor)
    fun spotByColor(command: CommandSpotByColor)
    fun spotByReg(command: CommandSpotByReg)
}
