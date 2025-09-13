import java.util.Scanner

fun task5() {
    val scanner = Scanner(System.`in`)

    print("Введите слова через пробел: ")
    val input = scanner.nextLine()
    val words = input.split(" ")

    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (!groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord] = mutableListOf()
        }
        groupedWords[sortedWord]!!.add(word)
    }

    groupedWords.values.forEach { group ->
        println(group.joinToString(", "))
    }
}

fun readInt(scanner: Scanner): Int? {
    try {
        return scanner.nextLine().toInt()
    } catch (e: NumberFormatException) {
        println("Ошибка: Введите целое число.")
        return null
    }
}

fun readIntArray(scanner: Scanner): IntArray? {
    try {
        return scanner.nextLine().split(" ").map { it.toInt() }.toIntArray()
    } catch (e: NumberFormatException) {
        println("Ошибка: Введите целые числа через пробел.")
        return null
    }
}