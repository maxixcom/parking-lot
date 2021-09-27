fun main() = readLine()!!.let { input ->
    val n = readLine()!!.toInt()
    if (n > 0 && n <= input.length) {
        println("Symbol # $n of the string \"$input\" is '${input[n - 1]}'")
    }
}
