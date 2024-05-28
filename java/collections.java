
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

void main() {
    var text = """
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
        """;

    /*
     * 1. Split words
     * 2. Filter numbers and symbols
     * 3. Group them
     * 4. Display words count
     * 5. Show the three most used words
     * 6. Print their sum.
     *
     * 19 lines (712 chars)
     */
    var sum = stream(text.split("\n")) // You have to wrap collections into streams
        .flatMap(it -> stream(it.split(" ")))
        .filter(it -> !it.isBlank())
        .filter(it -> it.chars().mapToObj(c -> (char)c).allMatch(Character::isLetter))
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(it -> it)) // Collecting is required for several operations
        .entrySet()
        .stream()
        .map(it -> Map.entry(it.getKey(), it.getValue().size()))
        .sorted(Map.Entry.comparingByValue())
        .collect(collectingAndThen(toList(), List::reversed))
        .stream()
        .peek(it -> System.out.printf("%s - %d%n", it.getKey(), it.getValue()))
        .toList()
        .subList(0, 3)
        .stream()
        .peek(it -> System.out.printf("() %s - %d%n", it.getKey(), it.getValue()))
        .mapToInt(Map.Entry::getValue)
        .sum();

    System.out.printf("TOTAL - %d%n", sum);
}
