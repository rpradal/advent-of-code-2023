package day02

import java.io.File

enum class Color(val repr: String, val max: Int) {
    BLUE("blue", 14),
    RED("red", 12),
    GREEN("green", 13),
}

data class Set(
    val draw: Map<Color, Int>,
)

fun Set.isPossible() = draw.all { it.value <= it.key.max }

fun String.toSet(): Set {
    return Set(
        draw =
            Color.values().associateWith {
                (
                    "(\\d+) ${it.repr}".toRegex().find(this)?.destructured?.component1()?.toInt() ?: 0
                )
            },
    )
}

data class Game(
    val id: Int,
    val sets: List<Set>,
)

fun Game.isPossible() = sets.all(Set::isPossible)

fun String.toGame(): Game {
    val (gameId) = "^Game (\\d+): (.*)".toRegex().find(this)!!.destructured
    val sets = this.substring(this.indexOf(": ") + 2)
    return Game(
        id = gameId.toInt(),
        sets = sets.split("; ").map(String::toSet),
    )
}

fun solveDay2Part1Puzzle(file: File): Int {
    return file
        .readLines()
        .map(String::toGame)
        .filter(Game::isPossible)
        .sumOf(Game::id)
}
