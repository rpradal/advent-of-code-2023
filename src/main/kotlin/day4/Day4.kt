package day4

import java.io.File


fun solveDay4Part1Puzzle(file: File): Int {
    return extractToOrderedIntervals(file)
        .count(::isContained)
}

fun solveDay4Part2Puzzle(file: File): Int {
    return extractToOrderedIntervals(file)
        .count(::isOverlapping)
}

private fun extractToOrderedIntervals(file: File): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
    return file.readLines()
        .map { it.split(",") }
        .map { it.map(::extractInterval) }
        .map { intervalList ->
            intervalList.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })
        }
        .map { Pair(it[0], it[1]) }
}

fun extractInterval(rangeString: String): Pair<Int, Int> {
    val bounds = rangeString.split("-").map(String::toInt)
    return Pair(bounds[0], bounds[1])
}

fun isContained(orderedPairs: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
    return orderedPairs.first.second >= orderedPairs.second.second
}

fun isOverlapping(orderedPairs: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
    return orderedPairs.first.second >= orderedPairs.second.first

}