package parking.console.command

class CommandFactoryImpl : CommandFactory {
    private val commands: List<(String) -> Command?> = listOf(
        { input -> parseStatus(input) },
        { input -> parseCreate(input) },
        { input -> parsePark(input) },
        { input -> parseLeave(input) },
        { input -> parseExit(input) },
    )

    override fun commandFromString(input: String) = commands.firstNotNullOfOrNull { it(input) } ?: CommandUnknown

    private fun parseStatus(input: String): Command? {
        return "^status$".toRegex().matchEntire(input)?.let {
            CommandStatus
        }
    }

    private fun parseCreate(input: String): Command? {
        return "^create\\s+(?<capacity>\\d+)$".toRegex().matchEntire(input)?.let {
            CommandCreate(
                capacity = it.groups["capacity"]!!.value.toInt(),
            )
        }
    }

    private fun parsePark(input: String): Command? {
        return "^park\\s+(?<regNumber>[\\w-]+)\\s+(?<color>\\w+)$".toRegex().matchEntire(input)?.let {
            CommandPark(
                regNumber = it.groups["regNumber"]!!.value,
                color = it.groups["color"]!!.value,
            )
        }
    }

    private fun parseLeave(input: String): Command? {
        return "^leave\\s+(?<slotId>\\d+)$".toRegex().matchEntire(input)?.let {
            CommandLeave(it.groups["slotId"]!!.value.toInt())
        }
    }

    private fun parseExit(input: String): Command? {
        return "^exit$".toRegex().matchEntire(input)?.let {
            CommandExit
        }
    }
}
