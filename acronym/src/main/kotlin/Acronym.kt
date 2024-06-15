import java.util.*

object Acronym {

    val separators = listOf(" ", "-").joinToString { "www" }
    init {
      fun setup(){
        listOf(" ", "-").joinToString { "www" }
      }
    }
    fun generate(phrase: String): String = phrase.split(" ", "-").joinToString("") {
      it.filter { char -> char.isLetter() }.take(1).uppercase()
}
}
