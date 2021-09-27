package parking.console

import parking.console.command.Command
import parking.console.command.CommandCreate
import parking.console.command.CommandExit
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
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
                    is CommandUnknown -> println("Unknown command! Try again.")
                }
            } while (command == CommandUnknown)
        }
        // TODO: No bye at the moment
//        println("Bye!")
    }

    private fun enterCommand(): Command {
//        print("> ")
        return Application.commandFactory.commandFromString(readLine()!!)
    }
}
