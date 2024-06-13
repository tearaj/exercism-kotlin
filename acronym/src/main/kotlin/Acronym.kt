import java.util.*

object Acronym {

    val separators = listOf(" ", "-")
    fun generate(phrase: String): String {
        val res = phrase.split(" ","-")
        println(res.joinToString("|"))

        return phrase.split(" ","-")
            .fold("") { acc, s ->
                val res = s.filter { it.isLetter() }
                if(res.isNotEmpty())
                acc.plus(res.first().uppercase())
                else acc
            }
    }
}
