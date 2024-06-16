import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

  fun ciphertext(plaintext: String): String {
    val normalized = plaintext.filter { it.isLetterOrDigit() }.lowercase().also { it.ifEmpty { return "" } }
    val numCols = ceil(sqrt(normalized.length.toDouble())).toInt()
    return normalized.chunked(numCols).let { chunkedList ->
      (0 until numCols).joinToString(" ") { indexOfChunk ->
        chunkedList.map { it.getOrNull(indexOfChunk) ?: " " }.joinToString("")
      }
    }
  }
}
