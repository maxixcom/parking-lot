fun main() {
    readLine()?.let {
        println("Elvis says: $it")
    } ?: throw IllegalStateException()
}
