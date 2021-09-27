package parking.domain.exception

class NoEmptySpotException(message: String = "Sorry, the parking lot is full.") : Exception(message)
