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

data class CrawlingState(
    val headPosition: Pair<Int, Int>,
    val tailPositions: List<Pair<Int, Int>>,
    val tailPositionHistory: List<Pair<Int, Int>>
)

fun computeNewFollowerPosition(leaderPosition: Pair<Int, Int>, followerPosition: Pair<Int, Int>): Pair<Int, Int> {
    if (abs(leaderPosition.first - followerPosition.first) <= 1 && abs(leaderPosition.second - followerPosition.second) <= 1) {
        return followerPosition
    }

    return when {
        leaderPosition.first == followerPosition.first -> followerPosition.first to (leaderPosition.second - followerPosition.second).sign + followerPosition.second
        leaderPosition.second == followerPosition.second -> (leaderPosition.first - followerPosition.first).sign + followerPosition.first to followerPosition.second
        else -> (leaderPosition.first - followerPosition.first).sign + followerPosition.first to (leaderPosition.second - followerPosition.second).sign + followerPosition.second
    }
}

data class Tail(
    val previous: Pair<Int, Int>,
    val startOfTailPositions: List<Pair<Int, Int>>
)

fun computeNewCrawling(crawlingState: CrawlingState, move: Move): CrawlingState {
    val newHeadPosition =
        crawlingState.headPosition.first + move.rowMove to crawlingState.headPosition.second + move.columnMove
    val newTailPositions = crawlingState.tailPositions.fold(Tail(newHeadPosition, listOf())) { acc, current ->
        val position = computeNewFollowerPosition(acc.previous, current)
        return@fold Tail(position, acc.startOfTailPositions + position)
    }.startOfTailPositions
    return CrawlingState(newHeadPosition, newTailPositions, crawlingState.tailPositionHistory + newTailPositions.last())
}

fun solveDay9Part1Puzzle(file: File): Int {
    return computedVisitedPositions(file, 1)
}

fun solveDay9Part2Puzzle(file: File): Int {
    return computedVisitedPositions(file, 9)
}

private fun computedVisitedPositions(file: File, tailSize: Int) = file.readLines()
    .map { it.split(" ") }
    .map { fromStringRepresentation(it[0]) to it[1].toInt() }
    .flatMap { pair -> List(pair.second) { pair.first } }
    .fold(CrawlingState(0 to 0, List(tailSize) { 0 to 0 }, listOf(0 to 0)), ::computeNewCrawling)
    .tailPositionHistory
    .toSet()
    .size
