class CustomSet(vararg nums:Int) {

    // TODO: implement proper constructor

    private val numsList = nums.toMutableList()

    fun isEmpty(): Boolean = numsList.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.containsAll(this.numsList)


    fun isDisjoint(other: CustomSet): Boolean = !other.containsAny(this.numsList)

    fun containsAll(other: MutableList<Int>) = numsList.containsAll(other)

    fun containsAny(other: MutableList<Int>) = numsList.filter { other.contains(it) }.isNotEmpty()

    fun contains(other: Int): Boolean = numsList.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val customSet = CustomSet()
        numsList.forEach {next -> other.contains(next).let { if(it) customSet.add(next) }}
        return customSet
    }

    fun add(other: Int)  = numsList.contains(other)
        .let { if(!it) numsList.add(other) }

    override fun equals(other: Any?): Boolean {
        if(other==null) return false
        if(other::class!=CustomSet::class) return false
        val otherCustomSet = other as CustomSet
        return numsList.filter { other.contains(it) }.let { it.size==otherCustomSet.size() && numsList.size==otherCustomSet.size() }
    }

    private fun addNums(list: MutableList<Int>){
         list.forEach{add(it)}
    }

    fun size() = numsList.size

    operator fun plus(other: CustomSet): CustomSet {
        val res = CustomSet()
        res.addNums(numsList)
        numsList.filterNot { other.contains(it) }
            .fold(res) { acc, i -> acc.apply { add(i) } }
        other.numsList.filterNot { numsList.contains(it) }
            .fold(res) { acc, i -> acc.apply { add(i) } }
        return res
    }

    operator fun minus(other: CustomSet): CustomSet =
        numsList.filterNot { other.contains(it) }.fold(CustomSet()) { acc, num -> acc.apply { add(num) } }
}
