package day03

import java.io.File

data class SymbolWithPosition(
    val symbol: Char,
    val rowIndex: Int,
    val colIndex: Int,
)

fun isValidAround(
    matrix: List<List<Char>>,
    rowIndex: Int,
    colIndex: Int,
): List<SymbolWithPosition> {
    val rowSize = matrix.size
    val colSize = matrix[rowIndex].size

    val rowStart = maxOf(0, rowIndex - 1)
    val rowEnd = minOf(rowSize - 1, rowIndex + 1)
    val colStart = maxOf(0, colIndex - 1)
    val colEnd = minOf(colSize - 1, colIndex + 1)

    val symbolsAround = mutableListOf<SymbolWithPosition>()
    for (rowIndex2 in rowStart..rowEnd) {
        val row = matrix[rowIndex2]
        for (colIndex2 in colStart..colEnd) {
            val col = row[colIndex2]
            if (!col.isDigit() && col != '.') {
                symbolsAround.add(SymbolWithPosition(col, rowIndex2, colIndex2))
            }
        }
    }

    return symbolsAround
}

fun parseProblem(file: File): List<Pair<Int, Set<SymbolWithPosition>>> {
    val gameMatrix = file.readLines().map(String::toList)
    val partNumbers = mutableListOf<Int>()
    val partValid = mutableListOf<Set<SymbolWithPosition>>()

    var partBeingCollected = ""
    var partBeingCollectedAround = mutableSetOf<SymbolWithPosition>()

    fun finalizeEndOfNumber() {
        partNumbers += partBeingCollected.toInt()
        partValid += partBeingCollectedAround
        partBeingCollected = ""
        partBeingCollectedAround = mutableSetOf()
    }

    for (rowIndex in gameMatrix.indices) {
        val row = gameMatrix[rowIndex]
        for (colIndex in row.indices) {
            val col = row[colIndex]
            if (col.isDigit()) {
                partBeingCollected += col
                partBeingCollectedAround.addAll(isValidAround(gameMatrix, rowIndex, colIndex))
            } else if (partBeingCollected.isNotEmpty()) {
                finalizeEndOfNumber()
            }
        }
        if (partBeingCollected.isNotEmpty()) {
            finalizeEndOfNumber()
        }
    }

    return partNumbers.zip(partValid)
}

fun solvePart1(file: File): Int {
    return parseProblem(file).filter { it.second.isNotEmpty() }.sumOf { it.first }
}

fun solvePart2(file: File): Int {
    return parseProblem(file)
        .map { it.first to it.second.filter { symbolWithPosition -> symbolWithPosition.symbol == '*' } }
        .flatMap {
            it.second.map { symbolWithPosition ->
                (
                    symbolWithPosition.rowIndex to symbolWithPosition.colIndex
                ) to it.first
            }
        }
        .groupBy { it.first }
        .filterValues { it.size == 2 }
        .map { it.value.map(Pair<*, Int>::second).reduce(Int::times) }
        .sum()
}
