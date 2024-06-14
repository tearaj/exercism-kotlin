import java.util.*

object Acronym {

    val separators = listOf(" ", "-")
    fun generate(phrase: String): String {
       return  phrase.split(" ","-")
            .map { it.filter { it.isLetter() } }
            .fold(""){acc, s-> acc.plus(s.firstOrNull().let { it?.uppercase() ?: "" })}
}}
