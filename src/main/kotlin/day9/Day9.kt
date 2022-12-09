package day9

import java.io.File
import kotlin.math.abs
import kotlin.math.sign

enum class Move(val rowMove: Int, val columnMove: Int) {
    UP(1, 0),
    DOWN(-1, 0),
    RIGHT(0, 1),
    LEFT(0, -1),
}

fun fromStringRepresentation(representation: String) = when (representation) {
    "U" -> Move.UP
    "D" -> Move.DOWN
    "R" -> Move.RIGHT
    "L" -> Move.LEFT
    else -> throw IllegalArgumentException()
}

data class Crawling(
    val headPosition: Pair<Int, Int>,
    val tailPosition: Pair<Int, Int>,
    val tailPositionHistory: List<Pair<Int, Int>>
)

fun computeNewTailPosition(headPosition: Pair<Int, Int>, tailPosition: Pair<Int, Int>): Pair<Int, Int> {
    if (abs(headPosition.first - tailPosition.first) <= 1 && abs(headPosition.second - tailPosition.second) <= 1) {
        return tailPosition
    }

    return when {
        headPosition.first == tailPosition.first -> tailPosition.first to (headPosition.second - tailPosition.second).sign + tailPosition.second
        headPosition.second == tailPosition.second -> (headPosition.first - tailPosition.first).sign + tailPosition.first to tailPosition.second
        else -> (headPosition.first - tailPosition.first).sign + tailPosition.first to (headPosition.second - tailPosition.second).sign + tailPosition.second
    }
}

fun computeNewCrawling(crawling: Crawling, move: Move): Crawling {
    val newHeadPosition = crawling.headPosition.first + move.rowMove to crawling.headPosition.second + move.columnMove
    val newTailPosition = computeNewTailPosition(newHeadPosition, crawling.tailPosition)
    return Crawling(newHeadPosition, newTailPosition, crawling.tailPositionHistory + newTailPosition)
}

fun solveDay9Part1Puzzle(file: File): Int {
    return file.readLines()
        .map { it.split(" ") }
        .map { fromStringRepresentation(it[0]) to it[1].toInt() }
        .flatMap { pair -> List(pair.second) { pair.first } }
        .fold(Crawling(0 to 0, 0 to 0, listOf(0 to 0)), ::computeNewCrawling)
        .tailPositionHistory
        .toSet()
        .size
}
