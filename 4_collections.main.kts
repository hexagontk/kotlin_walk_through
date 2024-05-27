
/*
   GENERICS
   =============================================================================

   Variance (only types)
   - <out T> producer, covariant (inheritance of C<T> same as T)
   - <in T> consumer, contravariant (inheritance of C<T> opposite of T)

   Invariant (types and functions)
   - <T> invariant (no inheritance on the generic type)
   - <T : Bound> bounded type (restrict valid types, like Java extends)
   - <T : Bound> where T : Interface (restrict the target types a bit more)
   - <T & Any> definitely non-nullable (forces that the type is not nullable)
   - <*> star projection
 */

data class Box<out T>(val item: T)

val x: Box<Int> = Box(1)
val y: Box<Double> = Box(1.0)

fun unwrap(box: Box<Number>): Number = box.item

// Calls can be made because Box is covariant (Box<Int> extends Box<Number>)
unwrap(x)
unwrap(y)

class NumberBox<T> where T : Number, T : Comparable<T>

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
data class Person(val name: String, val age: Int = 0)

val (name, age) = Person("Name", 18)
assert(name == "Name")
assert(age == 18)

map.forEach { (key, value) ->
    println("$key - $value")
}
