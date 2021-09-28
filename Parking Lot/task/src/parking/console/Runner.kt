package parking.console

import parking.console.command.Command
import parking.console.command.CommandCreate
import parking.console.command.CommandExit
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
import parking.console.command.CommandRegByColor
import parking.console.command.CommandSpotByColor
import parking.console.command.CommandSpotByReg
import parking.console.command.CommandStatus
import parking.console.command.CommandUnknown

class Runner {
    private val commandFactory = Application.commandFactory
    private val parkingLotController = Application.parkingLotController

    fun run() {
        main@ while (true) {
            do {
                val command = enterCommand()
                when (command) {
                    CommandExit -> break@main
                    is CommandLeave -> parkingLotController.leaveSpot(command)
                    is CommandPark -> parkingLotController.parkCar(command)
                    is CommandCreate -> parkingLotController.create(command)
                    is CommandStatus -> parkingLotController.status(command)
                    is CommandRegByColor -> parkingLotController.regByColor(command)
                    is CommandSpotByColor -> parkingLotController.spotByColor(command)
                    is CommandSpotByReg -> parkingLotController.spotByReg(command)
                    is CommandUnknown -> println("Unknown command! Try again.")
                }
            } while (command == CommandUnknown)
        }
    }

    private fun enterCommand(): Command {
        return Application.commandFactory.commandFromString(readLine()!!)
    }
}
