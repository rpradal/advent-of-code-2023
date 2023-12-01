package day01

import java.io.File

fun solveDay1Part1Puzzle(file: File): Int {
    return file
        .readLines()
        .map { "${it.first(Char::isDigit)}${it.last(Char::isDigit)}" }
        .map(String::toInt)
        .sum()
}

val mapping = (1..9).associateBy(Int::toString) + mapOf(
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
        .map { findPairs(it) to findLastPairs(it) }
        .map { "${it.first}${it.second}" }
        .map(String::toInt)
        .sum()
}

private fun findPairs(it: String): Int {
    return mapping.map { (stringRep, value) -> it.indexOf(stringRep) to value }.filter { it.first >= 0 }
        .sortedBy { it.first }.first().second
}

private fun findLastPairs(it: String): Int {
    return mapping.map { (stringRep, value) -> it.lastIndexOf(stringRep) to value }.filter { it.first >= 0 }
        .sortedBy { it.first }.last().second
}
