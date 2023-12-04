package day04

import java.io.File
import kotlin.math.pow

data class Card(
    val winningValues: Set<Int>,
    val possessedValues: Set<Int>,
)

fun parseListOfNumber(stringRepresentation: String): Set<Int> {
    return stringRepresentation
        .split(" ")
        .filter(String::isNotEmpty)
        .map(String::toInt)
        .toSet()
}

fun solvePart1(file: File): Int {
    return file
        .readLines()
        .asSequence()
        .map { it.replace("Card.*\\d+: ".toRegex(), "").split("|") }
        .map {
            Card(
                winningValues = parseListOfNumber(it[0]),
                possessedValues = parseListOfNumber(it[1]),
            )
        }
        .map { it.possessedValues.intersect(it.winningValues) }
        .map(Set<Int>::size)
        .filter { it > 0 }
        .sumOf { 2.toDouble().pow(it - 1) }
        .toInt()
}

fun solvePart2(file: File): Int {
    return -1
}
