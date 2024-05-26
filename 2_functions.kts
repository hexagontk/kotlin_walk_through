
/*
   FUNCTIONS
   =============================================================================

   - Methods can be overloaded
 */

// Parameters with default values
fun function(integer: Int = 0, parameter: String = "defect"): String =
    "$parameter $integer"

function() // Arguments by default
function(1)
function(parameter = "value") // Passing arguments by name

fun procedure() { println("Hello") } // Unit is optional

fun oneFunction() {
    val local = 1
    fun nestedFunction() = local
}

fun multipleArgs(vararg params: String) = params.joinToString("; ")

multipleArgs("One", "Two", "Three")

/*
   FUNCTION TYPES
   =============================================================================
 */

// Blocks of code stored as variables
val lambda: (Int, Int) -> String = { a: Int, b: Int -> "$a $b" }
val inferredLambda: (Int, Int) -> String = { a, b -> "$a $b" }

// You can use typealias to give more meaningful names to Function types
typealias IntInt2String = (Int, Int) -> String
val lambda2: IntInt2String = { a: Int, b: Int -> "$a $b" }

// They are invoked as a function
lambda(10, 20)

// Can be passed as a parameter
fun higherOrderFun(p: Int, lambda: (Int) -> Int) = lambda(p)

// If the lambda is the last parameter accepts alternative syntax
higherOrderFun(10, { it * 2 })
higherOrderFun(10) { it * 2 }

/*
   EXTENSION METHODS
   =============================================================================
 */

// Add methods to existing classes
// Useful to extend libraries without source code
fun String.addTimestamp() = this + " " + System.currentTimeMillis()

// The object on which they are applied is called 'receiver'
// You can specify a nullable receiver
fun String?.addNullTimestamp() =
    "${this ?: "This is null"} ${System.currentTimeMillis()}"

"hello".addTimestamp()
null.addNullTimestamp()

/*
   INFIX FUNCTIONS
   =============================================================================
 */
infix fun String.concat(d: Int) = "$this $d"

"A" concat 1_000_000

// Bit operators are infix functions
0b1 shl 1 and 0b0
