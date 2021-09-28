fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt().coerceIn(0..1_000_000)
    val house = when {
        rooms <= 1 -> Cabin(price)
        rooms in 2..3 -> Bungalow(price)
        rooms == 4 -> Cottage(price)
        rooms in 5..7 -> Mansion(price)
        else -> Palace(price)
    }

    println(house.totalPrice())
}

open class House(
    private val price: Int,
    private val k: Double = 1.0
) {
    open fun totalPrice(): Int = (price * k).toInt()
}

class Cabin(price: Int) : House(price, 1.0)
class Bungalow(price: Int) : House(price, 1.2)
class Cottage(price: Int) : House(price, 1.25)
class Mansion(price: Int) : House(price, 1.4)
class Palace(price: Int) : House(price, 1.6)
