package parking.domain.usecase

interface SpotByReg {
    fun execute(request: Request): Response

    data class Request(val regNumber: String)
    data class Response(val result: Result<List<Int>>)
}
