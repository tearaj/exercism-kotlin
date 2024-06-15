import java.util.*

object Acronym {
  fun generate(phrase: String): String = phrase.split(" ", "-")
    .map { it.filter { it.isLetter() } }
    .fold("") { acc, s ->
      acc.plus(s.firstOrNull().let { it?.uppercase() ?: "" })
    }
}

