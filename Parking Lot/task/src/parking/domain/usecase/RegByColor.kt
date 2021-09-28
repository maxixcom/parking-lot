package parking.domain.usecase

interface RegByColor {
    fun execute(request: Request): Response

    data class Request(val color: String)
    data class Response(val result: Result<List<String>>)
}
