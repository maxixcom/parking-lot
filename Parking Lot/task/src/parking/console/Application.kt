package parking.console

import parking.application.gateway.ParkingLotGatewayImpl
import parking.application.interactor.LeaveSpotImpl
import parking.application.interactor.ParkCarImpl
import parking.console.command.CommandFactory
import parking.console.command.CommandFactoryImpl
import parking.console.controller.ParkingLotController
import parking.console.controller.ParkingLotControllerImpl
import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.LeaveSpot
import parking.domain.usecase.ParkCar
import parking.persistence.ParkingLotRegistry
import parking.persistence.ParkingLotRegistryImpl

object Application {
    private val parkingLotRegistry: ParkingLotRegistry = ParkingLotRegistryImpl(2)
    private val parkingLotGateway: ParkingLotGateway = ParkingLotGatewayImpl(
        parkingLotRegistry = parkingLotRegistry
    )

    private val useCaseLeaveSpot: LeaveSpot = LeaveSpotImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseParkCar: ParkCar = ParkCarImpl(
        parkingLotGateway = parkingLotGateway
    )

    val commandFactory: CommandFactory = CommandFactoryImpl()

    val parkingLotController: ParkingLotController = ParkingLotControllerImpl(
        parkCar = useCaseParkCar,
        leaveSpot = useCaseLeaveSpot,
    )
}
