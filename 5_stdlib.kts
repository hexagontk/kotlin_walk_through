import java.io.File
import java.io.FileReader
import java.lang.IllegalStateException

/*
   STANDARD LIBRARY
   =============================================================================

   - Scope functions: let, run, with, apply, also
 */

// Take receiver and map it to another value
"Str".let { it.substring(it.indices) }

// Executes the passed block and returns receiver unchanged
"Str".apply { substring(0 until length) }

// Same as apply but with a parameter (use `it` instead `this`)
"Str".also {
    println(it.substring(0 until it.length - 1))
}

// Same as apply passing the instance as a parameter instead using a receiver
with("Str") { substring(0 until length) }

// For 'Closeable' objects
File("local_file.txt").writeText("text")
FileReader("local_file.txt").use {
    println(it.readText())
}

// Shortcut of if-param-throw
require(true) { "Invalid parameter" }

// Shortcut of if-var-throw
check(true) { "Invalid status" }

// Shortcut of `throw IllegalState ...
fun fail() { error("Invalid state") }
