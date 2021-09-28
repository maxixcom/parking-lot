import java.lang.NumberFormatException

fun intDivision(x: String, y: String): Int = try {
    x.toInt() / y.toInt()
} catch (e: Exception) {
    when (e) {
        is NumberFormatException -> println("Read values are not integers.")
        is ArithmeticException -> println("Exception: division by zero!")
        else -> throw e
    }
    0
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))
}
