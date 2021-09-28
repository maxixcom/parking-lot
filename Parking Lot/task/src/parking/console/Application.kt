package parking.console

import parking.application.gateway.ParkingLotGatewayImpl
import parking.application.interactor.CreateParkingLotImpl
import parking.application.interactor.LeaveSpotImpl
import parking.application.interactor.ParkCarImpl
import parking.application.interactor.RegByColorImpl
import parking.application.interactor.SpotByColorImpl
import parking.application.interactor.SpotByRegImpl
import parking.application.interactor.StatusParkingLotImpl
import parking.console.command.CommandFactory
import parking.console.command.CommandFactoryImpl
import parking.console.controller.ParkingLotController
import parking.console.controller.ParkingLotControllerImpl
import parking.domain.gateway.ParkingLotGateway
import parking.domain.usecase.CreateParkingLot
import parking.domain.usecase.LeaveSpot
import parking.domain.usecase.ParkCar
import parking.domain.usecase.RegByColor
import parking.domain.usecase.SpotByColor
import parking.domain.usecase.SpotByReg
import parking.domain.usecase.StatusParkingLot
import parking.persistence.ParkingLotRegistry
import parking.persistence.ParkingLotRegistryImpl

object Application {
    private val parkingLotRegistry: ParkingLotRegistry = ParkingLotRegistryImpl()
    private val parkingLotGateway: ParkingLotGateway = ParkingLotGatewayImpl(
        parkingLotRegistry = parkingLotRegistry
    )

    private val useCaseLeaveSpot: LeaveSpot = LeaveSpotImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseParkCar: ParkCar = ParkCarImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseCreateParkingLot: CreateParkingLot = CreateParkingLotImpl(
        parkingLotRegistry = parkingLotRegistry
    )

    private val useCaseStatusParkingLot: StatusParkingLot = StatusParkingLotImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseRegByColor: RegByColor = RegByColorImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseSpotByColor: SpotByColor = SpotByColorImpl(
        parkingLotGateway = parkingLotGateway
    )

    private val useCaseSpotByReg: SpotByReg = SpotByRegImpl(
        parkingLotGateway = parkingLotGateway
    )

    val commandFactory: CommandFactory = CommandFactoryImpl()

    val parkingLotController: ParkingLotController = ParkingLotControllerImpl(
        parkCar = useCaseParkCar,
        leaveSpot = useCaseLeaveSpot,
        createParkingLot = useCaseCreateParkingLot,
        statusParkingLot = useCaseStatusParkingLot,
        regByColor = useCaseRegByColor,
        spotByColor = useCaseSpotByColor,
        spotByReg = useCaseSpotByReg,
    )
}
