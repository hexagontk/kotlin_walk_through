
@file:Suppress("USELESS_IS_CHECK", "PackageDirectoryMismatch", "UnusedImport")

/*
   KOTLIN WALK-THROUGH
   =============================================================================

   Origin and Goals of Kotlin
   --------------------------

   - JetBrains developed Kotlin to meet its own needs:
     - Maintain a large amount of Java code (for Web and Desktop)
     - Designed to ease the development of tools (REPL and IDE)
     - Bidirectional Java integration to adopt it incrementally
     - It should be easy to learn for Java programmers

   - Released under Apache 2 license on GitHub in 2012
   - Version 1.0 released in February 2016
   - Led by JetBrains and Google by the Kotlin Foundation: kotlinfoundation.org


   Language DNA
   ------------

   - Compiled to:
     - Java bytecode: Android, Servers and Desktop
     - JavaScript: Browser
     - Native code: Linux, Mac, Windows (Beta)
     - WASM: Browser, Servers and Desktop (Experimental)

   - Uses static typing (and supports type inference)
   - Allows dynamic typing (for backend JavaScript only)
   - Multi paradigm: OO and FP [^1]
   - Can be run from the shell as scripts in `.kts` files

   [^1]: FP immutability, first level functions and "expressiveness"

   Type System
   -----------

   - `null` is part of the language, not the library (unlike Optional)
   - `Any` is the root of the type hierarchy (as Object in Java)
   - All instances are objects (`Int`, `Boolean`, `Float`). No primitive types
   - `Unit` is the equivalent of `void` in Java
   - `Nothing` is used by expressions that do not return any value

   Install Kotlin
   --------------

   - Most of the times you won't need to (Maven or Gradle will do it)
   - To install a Kotlin version manually, your best option would be sdkman.io
 */

/*
   CODE STRUCTURE
   =============================================================================
 */

// `KotlinLanguage.kt` compiles to class `com.example.KotlinLanguageKt`
// Common base packages' directories can be skipped
package com.example // Directory structure is not enforced

// Imports can be renamed (but don't overuse it)
import java.io.File as JavaFile
// Also works on methods
import java.util.Date.parse as parseDate
import java.io.FileReader

// Kotlin files can hold variables, constants and functions in addition to
// classes You can define many public classes in a file (good for prototyping)

// Definitions are `public` by default. They can also be `internal` or `private`
val packageVal = 0 // Java: import com.example.KotlinLanguageKt.getPackageVal
fun packageFun() = true // Java: com.example.KotlinLanguageKt.packageFun()

// Executed as `java com.example.KotlinLanguageKt`.
fun main() { // args are optional: `vararg args: String` or `args: Array<String>`
    println("Hello Kotlin!")
}

/*
   VARIABLES, CONSTANTS AND LITERALS
   =============================================================================

   - Avoid type inference outside local scope
 */

val booleanConstant: Boolean = true
// booleanConstant = false // Compile error

object Constants {
    const val JAVA_CONSTANT = true // Basic types only (Int, String...)
    const val STRING_CONSTANT = "string" // Declared only in objects or top level
}

var multilineText: String = """multiline strings with
    substitution of variables $booleanConstant ${2 + 2}"""

// Allows creation of not null vars without initial values
lateinit var lateInitVariable: String

val hexLiteral: Int = 0xCAFE
val bitLiteral: Int = 0b0101_0101_0101

// Initialized on first access
val lazyInit: Long by lazy { System.currentTimeMillis() }

/*
   EQUALITY
   =============================================================================

   ==, !=, ===, !==
 */

val az = "a".."z"

// The `==` operator is the same as the `equals` method
assert(az == "a".."z")
assert(az == az)

// Reference equality is done with the `===` operator
assert(az !== "a".."z")
assert(az === az)

/*
   `NULL` MANAGEMENT
   =============================================================================

   - If `null` is checked, the reference makes a cast of T? to T
 */

val integer: Int? = null // '?' Indicates optional value
//val error: Int = integer + 1

val notNull: String? = "not null"

// There are null checking utilities in the standard library
checkNotNull(notNull) { "Exception's message if value is null. It is optional" }

requireNotNull(notNull) {
    "This method does the same, but throwing an IllegalArgumentException"
}

// With `?:` You can control `null` in a concise way
val ok: Int = (integer ?: 0) + 1

data class Address(val street: String, val locality: String?)
val address: Address? = Address("Fifth Avenue, 1", "New York")

// Operator safe call `?.`
val locality: String = address?.locality ?: "Without locality"

/*
   WHEN
   =============================================================================
 */

val state: Any = 0

// Automatic Cast
when (state) {
    is String -> println(state.substring (1..2))
    in 1..9 -> println("Int")
    !in 1..9 -> println("Out of range")
    10, 20, 50 -> println ("Tens")
    0 -> println ("Zero")

    else -> println ("None of the above")
}

// Can be used as a cleaner if-elseif
when {
    state is Int && state > 10 -> println("+ 10")
    "" is String -> println("Empty string")
    else -> println("Never run")
}
