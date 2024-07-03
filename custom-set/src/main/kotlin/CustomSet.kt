class CustomSet(vararg nums:Int) {

    private val numsList = nums.toMutableList()

    fun isEmpty(): Boolean = numsList.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.containsAll(this.numsList)


    fun isDisjoint(other: CustomSet): Boolean = other.containsAny(this.numsList).not()

    fun containsAll(other: MutableList<Int>) = numsList.containsAll(other)

    fun containsAny(other: MutableList<Int>) = numsList.filter { other.contains(it) }.isNotEmpty()

    fun contains(other: Int): Boolean = numsList.contains(other)

    fun intersection(other: CustomSet): CustomSet = numsList.filter { other.contains(it) }
      .fold(CustomSet()) { acc, i -> acc.apply { add(i) } }

    fun add(other: Int)  = numsList.contains(other)
        .let { if(!it) numsList.add(other) }

    override fun equals(other: Any?): Boolean {
        if(other==null) return false
        if(other::class!=CustomSet::class) return false
        val otherCustomSet = other as CustomSet
        return numsList.filter { other.contains(it) }.let { it.size==otherCustomSet.size() && numsList.size==otherCustomSet.size() }
    }


    fun size() = numsList.size

    operator fun plus(other: CustomSet): CustomSet = (numsList+other.numsList).distinct().toIntArray().let { CustomSet(*it) }

    operator fun minus(other: CustomSet): CustomSet =
        numsList.filterNot { other.contains(it) }.fold(CustomSet()) { acc, num -> acc.apply { add(num) } }
}
