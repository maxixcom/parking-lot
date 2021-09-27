package parking.console

import parking.console.command.Command
import parking.console.command.CommandExit
import parking.console.command.CommandLeave
import parking.console.command.CommandPark
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
                    is CommandUnknown -> println("Unknown command! Try again.")
                }
            } while (command == CommandUnknown)
        }
        println("Bye!")
    }

    private fun enterCommand(): Command {
        print("> ")
        return Application.commandFactory.commandFromString(readLine()!!)
    }
}
