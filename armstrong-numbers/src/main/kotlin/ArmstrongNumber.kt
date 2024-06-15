import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val l = input.toString().count()
        return input.toString().map {
            it.digitToInt().toDouble().pow(l).toInt()
        }.sum() == input
    }

}
