import ScrabbleScore.pointMap

object ScrabbleScore {

  val compressedMap = mapOf(
    1 to listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
    2 to listOf('D', 'G'),
    3 to listOf('B', 'C', 'M', 'P'),
    4 to listOf('F', 'H', 'V', 'W', 'Y'),
    5 to listOf('K'),
    8 to listOf('J', 'X'),
    10 to listOf('Q', 'Z')
  )

  val pointMap = compressedMap.map { it }
    .fold(mutableMapOf<Char, Int>()) { acc, entry ->
      entry.value.forEach { acc.put(it, entry.key) }
      acc
    }

  fun scoreWord(word: String): Int {
    return word.uppercase().sumOf { pointMap.getOrElse(it) { 0 } }
  }
}
