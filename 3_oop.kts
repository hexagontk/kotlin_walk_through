
/*
   CLASSES
   =============================================================================
 */

interface Interface {
    val value: Int // Interfaces may contain variables
    fun function(): String
}

abstract class AbstractClass {
    abstract fun function(): String
}

// Classes are 'final' by default (problem for Mocks and Spring)
// The parameters of the main constructor are defined in the class
open class BaseClass(val field: String = "foo")

// param is only visible in the initialization
class AClass(param: String, val property: Int = 0): BaseClass(param), Interface {

    var property2 = param
    override val value = 42

    init {
        println(param)
    }

    constructor(): this("parameter", 99)

    fun method() = "result"
    override fun function() = "implemented"
}

val aClass = AClass("parameter") // 'new' is not used

/*
   ENUMS
   =============================================================================

   - Can have members and methods
   - May implement interfaces
 */

interface Balance {
    fun balanced(): Boolean
}

enum class Vehicle(private val wheels: Int) : Balance {
    MOTORBIKE(2),
    CAR(4),
    TRUCK(6);

    override fun balanced(): Boolean =
        wheels > 2
}

/*
   PROPERTIES
   =============================================================================
 */

class PersonV1 {
    var age: Int = 0
}

// `field` is the variable to assign the new field value
class PersonV2 {
    var age: Int = 0
        set(value) {
            require(value < 18)
            field = value
        }
}

// Compiles with `PersonV1` and `PersonV2`
val person = PersonV1()

// With `PersonV2` throws an exception
person.age = 80

/*
   EXTENSION FIELDS
   =============================================================================

   Extension fields are syntactic sugar for extension methods
 */

val Collection<T>.head: T
    get() = this.get(0)

/*
   DATA CLASSES
   =============================================================================

   - They are named tuples (can be used in "destructuring")
 */

// immutable DTO (overwrites `equals`,` hashcode` and `toString`
// Can implement interfaces, can not inherit classes
data class Person(val name: String, val age: Int = 0)

val linux = Person("Linux Torvalds", 50)

// Copy instance by changing fields
val linus = linux.copy(
    name = "Linus Torvalds",
    age = 51,
)

/*
   STATICS AND OBJECTS (SINGLETONS)
   =============================================================================
 */

class Statics {
    // It is better to use package level methods
    companion object {
        fun staticMethod() {}
    }
}

object Singleton {
    fun singletonMethod() {}
}

/*
   OPERATOR OVERLOADING
   =============================================================================

   - Operators can be overloaded / overwritten, can't define new ones (as Scala)
   - To define a new operator, use an infix function (closest syntax)
   - Can be defined as extension functions or inside classes
 */

operator fun String.get(range: IntRange) = this.subSequence(range)

"abcde"[1..3]
"abcde"[1 until 3]

/*
   SEALED CLASSES
   =============================================================================
 */

sealed class Value {
    class IntValue(val integer: Int) : Value()
    class StringValue(val string: String) : Value()
    data object SpaceValue : Value()
}

val input: Value = Value.IntValue(9)

when (input) {
    is Value.IntValue -> println("Sealed Int" + input.integer)
    is Value.StringValue -> println("Sealed String" + input.string)
    is Value.SpaceValue -> println("Sealed Space")
    else -> println("None of the above")
}
