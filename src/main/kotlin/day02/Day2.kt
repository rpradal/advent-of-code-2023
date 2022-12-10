package day02

import java.io.File

enum class Choice(val score: Int) {
    ROCK(1), PAPER(2), SCISSOR(3)
}

enum class MatchIssue(val score: Int) {
    WIN(6), DRAW(3), LOSE(0)
}

val MATCH_ISSUE_TO_DELTA = mapOf(
    MatchIssue.WIN to 1,
    MatchIssue.LOSE to 2,
    MatchIssue.DRAW to 0,
)

val DELTA_TO_MATCH_ISSUE = MATCH_ISSUE_TO_DELTA.entries.associate { it.value to it.key }

fun <K, V> Map<K, V>.getOrThrow(key: K) = this.getOrElse(key) { throw IllegalArgumentException() }

fun choiceFromStringRepresentation(representation: String): Choice {
    return when (representation) {
        "A", "X" -> Choice.ROCK
        "B", "Y" -> Choice.PAPER
        "C", "Z" -> Choice.SCISSOR
        else -> throw IllegalArgumentException()
    }
}

fun matchIssueFromStringRepresentation(representation: String): MatchIssue {
    return when (representation) {
        "X" -> MatchIssue.LOSE
        "Y" -> MatchIssue.DRAW
        "Z" -> MatchIssue.WIN
        else -> throw IllegalArgumentException()
    }
}

fun findMatchIssue(user: Choice, opponent: Choice): MatchIssue {
    return DELTA_TO_MATCH_ISSUE.getOrThrow(((WINNING_ORDER.indexOf(user) - WINNING_ORDER.indexOf(opponent)).mod(3)))
}

fun findChoiceForMatchIssue(opponent: Choice, matchIssue: MatchIssue): Choice {
    return WINNING_ORDER[(WINNING_ORDER.indexOf(opponent) + MATCH_ISSUE_TO_DELTA.getOrThrow(matchIssue)) % 3]
}

val WINNING_ORDER: List<Choice> = listOf(Choice.ROCK, Choice.PAPER, Choice.SCISSOR)

fun solveDay2Part1Puzzle(file: File): Int {
    return file.readLines().map {
        it.split(" ").map(::choiceFromStringRepresentation)
    }.map {
        Pair(it[1], findMatchIssue(it[1], it[0]))
    }.sumOf {
        it.first.score + it.second.score
    }
}

fun solveDay2Part2Puzzle(file: File): Int {
    return file.readLines().map {
        it.split(" ")
    }.map {
        choiceFromStringRepresentation(it[0]) to matchIssueFromStringRepresentation(it[1])
    }.map {
        findChoiceForMatchIssue(it.first, it.second) to it.second
    }.sumOf { it.first.score + it.second.score }
}
