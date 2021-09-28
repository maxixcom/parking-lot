fun parseCardNumber(cardNumber: String): Long =
    "^\\d{4} \\d{4} \\d{4} \\d{4}$".toRegex().matchEntire(cardNumber)?.let {
        cardNumber.replace(" ", "").toLong()
    } ?: throw Exception("Card number is incorrect")
