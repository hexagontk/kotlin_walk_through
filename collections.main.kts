
val text = """
    Computer programming or coding is the composition of sequences of instructions, called programs, that computers can
    follow to perform tasks.[1][2] It involves designing and implementing algorithms, step-by-step specifications of
    procedures, by writing code in one or more programming languages. Programmers typically use high-level programming
    languages that are more easily intelligible to humans than machine code, which is directly executed by the central
    processing unit. Proficient programming usually requires expertise in several different subjects, including
    knowledge of the application domain, details of programming languages and generic code libraries, specialized
    algorithms, and formal logic.

    Auxiliary tasks accompanying and related to programming include analyzing requirements, testing, debugging
    (investigating and fixing problems), implementation of build systems, and management of derived artifacts, such as
    programs' machine code. While these are sometimes considered programming, often the term software development is
    used for this larger overall process – with the terms programming, implementation, and coding reserved for the
    writing and editing of code per se. Sometimes software development is known as software engineering, especially when
    it employs formal methods or follows an engineering design process.
    """

/*
 * 1. Split words
 * 2. Filter numbers and symbols
 * 3. Group them
 * 4. Display words count
 * 5. Show the three most used words
 * 6. Print their sum.
 *
 * 15 lines (586 chars)
 */
text
    .split("\n") // Splits lines
    .flatMap { it.split(" ") } // Split lines' words and join them
    .filter { it.isNotBlank() }
    .filter { it.toCharArray().all(Char::isLetter) } // Discard symbols
    .map(String::lowercase)
    .groupBy { it }
    .map { (k, v) -> k to v.size } // Pairs of word -> count
    .sortedBy { it.second }
    .reversed()
    .onEach { (k, v) -> println("$k - $v") } // Peek an element
    .take(3)
    .onEachIndexed { i, (k, v) -> println("(${i+1}) $k - $v") } // Indexed operations
    .sumOf { it.second }
    .let { println("TOTAL - $it") }
