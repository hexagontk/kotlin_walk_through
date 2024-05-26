
@file:Suppress("USELESS_IS_CHECK", "FunctionName")

/*
   TESTING
   =============================================================================

   TODO Add other Kotlin default assertions
 */

// Functions can have names with spaces (useful for tests)
fun `If this then that`() {
    assertEquals("a", "a")
    assert("" is String)
}

/*
   CODE DOCUMENTATION
   =============================================================================

   - Dokka is used to generate API documentation
   - Output can be Markdown or HTML
 */

class DokkaClass

/**
 * You can document code using *Markdown*. And link other elements with brackets
 * [DokkaClass].
 *
 * @param intParam Tags for documenting parameters are similar to Javadoc ones.
 * @param stringParam Another parameter.
 * @return Return value.
 */
fun dokka(intParam: Int, stringParam: String): String =
    "Code documentation $intParam $stringParam"

/*
   OTHER FEATURES
   =============================================================================

   - Multi-platform projects: sharing common code across platforms
   - Asynchronous programming helpers (coroutines)

   Tools
   -----

   - Gradle: https://kotlinlang.org/docs/reference/using-gradle.html
   - Maven: https://kotlinlang.org/docs/reference/using-maven.html
   - IntelliJ IDEA: https://www.jetbrains.com/idea
   - Eclipse: https://github.com/JetBrains/kotlin-eclipse
   - SonarQube: https://docs.sonarqube.org/display/PLUG/SonarKotlin
   - Detekt: static code analysis

   - And of course... Vim: https://github.com/udalov/kotlin-vim

   Third-party libraries
   ---------------------

   - Official Android language (Google support)
   - Web (Kotlin): Ktor, HTTP4K, Hexagon
   - Web (Java): Vert.x, Spring Boot, Micronaut, Jooby and Javalin
   - Testing: MockK, Kotest and Spek
   - Dependency injection: Kodein and Injekt

   - It's very easy to use Java libraries, and they work perfectly

   Resources
   ---------

   - Kotlin documentation: very complete and precise
   - Kotlin Coding Standard
   - Kotlin koans: when you finish them you will know the language quite well
   - Kotlin playground: http://play.kotlinlang.org
   - Blog: latest language news
   - Slack: very active (has a channel in Spanish)
   - Java/Kotlin comparison: https://www.kotlinvsjava.com

   That's all folks!
   -----------------

   Thanks for coming
   If you have questions, go ahead
 */
