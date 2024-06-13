object HandshakeCalculator {
  private val lookup = mapOf(
    1 to Signal.WINK,
    2 to Signal.DOUBLE_BLINK,
    4 to Signal.CLOSE_YOUR_EYES,
    8 to Signal.JUMP
  )

  private infix fun Int.hasBitSet(bit: Int): Boolean = ((this shr bit) and 0x1) == 1
  fun calculateHandshake2(number: Int): List<Signal> {
    return mutableListOf<Signal>().apply {
      if (number hasBitSet 0) add(Signal.WINK)
      if (number hasBitSet 1) add(Signal.DOUBLE_BLINK)
      if (number hasBitSet 2) add(Signal.CLOSE_YOUR_EYES)
      if (number hasBitSet 3) add(Signal.JUMP)
      if (number hasBitSet 4) reverse()
    }
  }


  fun calculateHandshake(number: Int): List<Signal> =
    lookup.mapNotNull { number.and(it.key) checkEquality (it.key to it.value) }
      .let { if (number and 16 == 16) it.reversed() else it }

private infix fun Int.checkEquality(params: Pair<Int, Signal>): Signal? =
  if (this == params.first) params.second else null

}
