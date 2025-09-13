import java.util.Scanner

fun task4() {
    val scanner = Scanner(System.`in`)

    print("Введите первый массив чисел через пробел: ")
    val array1 = readIntArray(scanner) ?: return

    print("Введите второй массив чисел через пробел: ")
    val array2 = readIntArray(scanner) ?: return

    val intersection = mutableListOf<Int>()
    val counts1 = mutableMapOf<Int, Int>()
    val counts2 = mutableMapOf<Int, Int>()

    for (num in array1) {
        counts1[num] = counts1.getOrDefault(num, 0) + 1
    }

    for (num in array2) {
        counts2[num] = counts2.getOrDefault(num, 0) + 1
    }

    for ((num, count1) in counts1) {
        val count2 = counts2.getOrDefault(num, 0)
        val minCount = minOf(count1, count2)
        repeat(minCount) {
            intersection.add(num)
        }
    }

    println("Пересечение массивов: ${intersection.joinToString(", ")}")
}
