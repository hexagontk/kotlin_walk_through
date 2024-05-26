
/*
   GENERICS
   =============================================================================

   TODO
 */

/*
   ARRAYS AND RANGES
   =============================================================================

   - They are classes, not language constructions
   - Ranges: 1..2 (both included) 1 until 3 (3 not included)
 */

// Can be initialized with a lambda
val array: Array<Int> = Array(5) { ii -> ii * 2 } // [ 0, 2, 4, 6, 8 ]

val arrayLiteral = arrayOf(1, 2, 3)

// Transform arrays into lists (and vice versa)
array.toList()
listOf('A', 'B', 'C').toTypedArray()

val firstPosition = array[0]
val subArray: List<Int> = array.slice(1..2) // '1..2' is a range of integers

/*
   LISTS
   =============================================================================
 */

// They are not modifiable
val list = listOf(0, 1, 2)
assert(list[0] == 0)
assert(1 in list)
assert(3 !in list)

val mutableList = mutableListOf(0, 1, 2)

/*
   MAPS (AND PAIRS)
   =============================================================================
 */

val pair: Pair<String, String> = "key" to "value" // pair.first & pair.second

val map = mapOf(
    "Spain" to "ES",
    "United Kingdom" to "UK",
    pair,
)

assert("Spain" in map)
assert(map["Spain"] == "ES")

val map2 = map + ("Italy" to "IT")

val mutableMap: MutableMap<String, Any> = mutableMapOf("a" to 0, "b" to true)
mutableMap["a"] = 'C'

/*
   DESTRUCTURING
   =============================================================================
 */

val (name, age) = Person("Name", 18)
assert(name == "Name")
assert(age == 18)

map.forEach { (key, value) ->
    println("$key - $value")
}
