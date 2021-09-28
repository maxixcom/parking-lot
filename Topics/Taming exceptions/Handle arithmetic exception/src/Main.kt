fun main() = try {
    val (a, b) = List(2) { readLine()!!.toInt() }
    println(a / b)
} catch (e: ArithmeticException) {
    println("Division by zero, please fix the second argument!")
}
