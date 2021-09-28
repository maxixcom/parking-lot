package parking.domain.usecase

interface SpotByColor {
    fun execute(request: Request): Response

    data class Request(val color: String)
    data class Response(val result: Result<List<Int>>)
}
