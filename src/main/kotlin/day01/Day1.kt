package day01

import java.io.File

fun solveDay1Part1Puzzle(file: File): Int {
    return file
        .readLines()
        .map { "${it.first(Char::isDigit)}${it.last(Char::isDigit)}" }
        .sumOf(String::toInt)
}

val mapping =
    (1..9).associateBy(Int::toString) +
        mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )

fun solveDay1Part2Puzzle(file: File): Int {
    return file
        .readLines()
        .map { "${findFirstDigit(it)}${findLastDigit(it)}" }
        .sumOf(String::toInt)
}

private fun findFirstDigit(line: String): Int {
    return mapping.mapKeys { (stringRep, _) -> line.indexOf(stringRep) }
        .filter { it.key >= 0 }
        .minByOrNull { it.key }!!.value
}

private fun findLastDigit(line: String): Int {
    return mapping.mapKeys { (stringRep, _) -> line.lastIndexOf(stringRep) }
        .filter { it.key >= 0 }
        .maxByOrNull { it.key }!!.value
}
