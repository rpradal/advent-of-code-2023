package day08

import java.io.File

fun solveDay8Part1Puzzle(file: File): Int {
    val parsedPuzzle = file.readLines().map { it.toList().map { it.toString().toInt() } }

    val visibleTreePositionsLeftToRight = verticalCount(parsedPuzzle) { it.first to it.second }
    val visibleTreePositionsRightToLeft =
        verticalCount(parsedPuzzle) { it.first to (parsedPuzzle[0].size - 1 - it.second) }
    val visibleTreePositionsTopToBottom = verticalCount(parsedPuzzle) { it.second to it.first }
    val visibleTreePositionsBottomToTop = verticalCount(parsedPuzzle) { parsedPuzzle.size - 1 - it.second to it.first }
    return (visibleTreePositionsLeftToRight + visibleTreePositionsRightToLeft + visibleTreePositionsTopToBottom + visibleTreePositionsBottomToTop).size
}

fun solveDay8Part2Puzzle(file: File): Int {
    val parsedPuzzle = file.readLines().map { it.toList().map { it.toString().toInt() } }
    val puzzleDim = parsedPuzzle.size
    val view = mutableSetOf<Int>()
    for (i in 0 until puzzleDim) {
        for (j in 0 until puzzleDim) {
            view.add(getViewableFrom(parsedPuzzle, i to j))
        }
    }
    return view.max()
}

fun getViewableFrom(parsedPuzzle: List<List<Int>>, position: Pair<Int, Int>): Int {
    val puzzleDim = parsedPuzzle.size
    val treeHeight = parsedPuzzle[position.first][position.second]
    var visibilityRight = 0
    for (i in position.second until puzzleDim) {
        visibilityRight = i - position.second
        if (parsedPuzzle[position.first][i] >= treeHeight && i != position.second) {
            break
        }
    }

    var visibilityLeft = 0
    for (i in position.second downTo 0) {
        visibilityLeft = position.second - i
        if (parsedPuzzle[position.first][i] >= treeHeight && i != position.second) {
            break
        }
    }

    var visibilityTop = 0
    for (i in position.first downTo 0) {
        visibilityTop = position.first - i
        if (parsedPuzzle[i][position.second] >= treeHeight && i != position.first) {
            break
        }
    }

    var visibilityBottom = 0
    for (i in position.first until puzzleDim) {
        visibilityBottom = i - position.first
        if (parsedPuzzle[i][position.second] >= treeHeight && i != position.first) {
            break
        }
    }

    return visibilityRight * visibilityLeft * visibilityTop * visibilityBottom
}

private fun verticalCount(
    parsedPuzzle: List<List<Int>>,
    positionToConsider: (iterators: Pair<Int, Int>) -> Pair<Int, Int>
): MutableSet<Pair<Int, Int>> {
    val visibleTreePositions = mutableSetOf<Pair<Int, Int>>()
    val puzzleDim = parsedPuzzle.size
    for (i in 0 until puzzleDim) {
        var height = -1
        for (j in 0 until puzzleDim) {
            val (row, column) = positionToConsider(i to j)
            if (parsedPuzzle[row][column] <= height) {
                continue
            }
            height = parsedPuzzle[row][column]
            visibleTreePositions.add(row to column)
        }
    }
    return visibleTreePositions
}
