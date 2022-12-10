package day01

import java.io.File

fun solveDay1Part1Puzzle(file: File): Int {
    return extractElvesCarrying(file).maxOf { it }
}

fun solveDay1Part2Puzzle(file: File): Int {
    return extractElvesCarrying(file).sortedDescending().take(3).sum()
}

private fun extractElvesCarrying(file: File): List<Int> {
    return file
        .readLines()
        .joinToString(",")
        .split(",,")
        .map { it.split(",").map(String::toInt) }
        .map { it.sum() }
}
