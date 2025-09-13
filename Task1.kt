import java.util.Scanner

fun task1() {
    val scanner = Scanner(System.`in`)

    print("Введите количество строк: ")
    val rows = readInt(scanner) ?: return

    print("Введите количество столбцов: ")
    val cols = readInt(scanner) ?: return

    val matrix = Array(rows) { IntArray(cols) }

    println("Введите трехзначные числа для заполнения массива:")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Элемент [$i][$j]: ")
            val input = readInt(scanner)

            if (input == null || input < 100 || input > 999) {
                println("Ошибка: Введите трехзначное число.")
                return
            }
            matrix[i][j] = input
        }
    }

    val distinctDigits = matrix.flatMap { it.map { it.toString().toList() } }
        .flatten()
        .distinct()
        .count()

    println("Двумерный массив:")
    matrix.forEach { row -> println(row.joinToString(" ")) }

    println("В массиве использовано $distinctDigits различных цифр")
}
