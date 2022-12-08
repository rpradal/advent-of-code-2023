package day5

import java.io.File

fun solveDay5Part1Puzzle(file: File): String {
    val (state, moves) = parseProblem(file)

    moves.map {
        repeat(it.crateNumber) { _ ->
            val crate = state[it.originColumnIndex].removeLast()
            state[it.destinationColumnIndex].addLast(crate)
        }
    }

    return state.map(ArrayDeque<Char>::removeLast).joinToString("")
}

fun solveDay5Part2Puzzle(file: File): String {
    val (state, moves) = parseProblem(file)

    moves.map {
        val slicedRange = state[it.originColumnIndex].size - it.crateNumber until state[it.originColumnIndex].size
        val toAdd = state[it.originColumnIndex].slice(slicedRange)
        state[it.destinationColumnIndex].addAll(toAdd)
        repeat(it.crateNumber) { _ -> state[it.originColumnIndex].removeLast() }
    }

    return state.map(ArrayDeque<Char>::removeLast).joinToString("")
}

fun parseProblem(file: File): Pair<List<ArrayDeque<Char>>, List<Move>> {
    val problemParts = file.readLines().joinToString("\n").split("\n\n")
    val parsedInitialState = parseInitialState(problemParts[0])
    val moves = parseMoves(problemParts[1])
    return parsedInitialState to moves
}

data class Move(
    val originColumnIndex: Int,
    val destinationColumnIndex: Int,
    val crateNumber: Int
)

fun parseMoves(rawMoves: String): List<Move> {
    return rawMoves.split("\n").map {
        val (crateNumber, originColumnIndex, destinationColumnIndex) = it.split(" ").mapNotNull(String::toIntOrNull)
        Move(originColumnIndex - 1, destinationColumnIndex - 1, crateNumber)
    }
}

fun parseInitialState(rawInitialState: String): List<ArrayDeque<Char>> {
    val preParsedProblem = rawInitialState
        .split("\n")
        .reversed()
    val columnCount = preParsedProblem[0]
        .split(" ")
        .mapNotNull { it.toIntOrNull() }
        .max()
    val baseStructure = arrayOfNulls<ArrayDeque<Char>>(columnCount).map { ArrayDeque<Char>() }

    preParsedProblem.drop(1).map {
        baseStructure.mapIndexed { index, queue ->
            if (it.length >= index * 4 + 2 && it[index * 4 + 1] != ' ') queue.add(it[index * 4 + 1])
        }
    }

    return baseStructure
}
