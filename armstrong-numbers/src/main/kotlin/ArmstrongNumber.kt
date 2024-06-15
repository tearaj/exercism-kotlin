import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val l = input.toString().count()
        return input.toString().fold(0) {
            acc,c -> acc.plus(c.digitToInt().toDouble().pow(l).toInt())
        } == input
    }

}
