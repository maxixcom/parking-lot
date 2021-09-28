fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = when (productType) {
        "headphones" -> Headphones(price)
        "smartphone" -> Smartphone(price)
        "tv" -> Tv(price)
        "laptop" -> Laptop(price)
        else -> Product(price)
    }

    println(product.totalPrice())
}

open class Product(
    private val price: Int,
    private val tax: Int = 0
) {
    fun totalPrice() = price + price * tax / 100
}

class Headphones(price: Int) : Product(price, 11)
class Smartphone(price: Int) : Product(price, 15)
class Tv(price: Int) : Product(price, 17)
class Laptop(price: Int) : Product(price, 19)
