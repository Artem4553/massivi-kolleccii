import java.util.Scanner

fun task3() {
    val alphabet = arrayOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
        'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'
    )
    val numbers = arrayOf(
        21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31,
        32, 19, 7, 17
    )

    val charIndexMap = alphabet.zip(numbers.map { it - 1 }).toMap() // -1 для соответствия индексам массива

    val scanner = Scanner(System.`in`)

    print("Введите ключевое слово: ")
    val keyword = scanner.nextLine().uppercase()

    print("Введите исходный текст: ")
    val plaintext = scanner.nextLine().uppercase()

    val ciphertext = StringBuilder()
    var keywordIndex = 0

    for (char in plaintext) {
        if (char.isLetter()) {
            val shift = charIndexMap[keyword[keywordIndex % keyword.length]] ?: 0
            val charIndex = alphabet.indexOf(char)
            val shiftedIndex = (charIndex + shift) % alphabet.size
            ciphertext.append(alphabet[shiftedIndex])
            keywordIndex++
        } else {
            ciphertext.append(char)
        }
    }

    println("Зашифрованный текст: $ciphertext")
}