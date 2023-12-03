package day03

import java.io.File

fun isValidAround(matrix: List<List<Char>>, rowIndex: Int, colIndex: Int): Boolean {
    val rowSize = matrix.size
    val colSize = matrix[rowIndex].size

    val rowStart = maxOf(0, rowIndex - 1)
    val rowEnd = minOf(rowSize - 1, rowIndex + 1)
    val colStart = maxOf(0, colIndex - 1)
    val colEnd = minOf(colSize - 1, colIndex + 1)

    for (rowIndex2 in rowStart..rowEnd) {
        val row = matrix[rowIndex2]
        for (colIndex2 in colStart..colEnd) {
            val col = row[colIndex2]
            if (!col.isDigit() && col != '.') {
                return true
            }
        }
    }

    return false
}

fun solvePart1(file: File): Int {
    val gameMatrix = file.readLines().map(String::toList)
    val partNumbers = mutableListOf<Int>()
    val partValid = mutableListOf<Boolean>()

    var partBeingCollected = ""
    var partBeingCollectedValid = false

    fun finalizeEndOfNumber() {
        partNumbers += partBeingCollected.toInt()
        partValid += partBeingCollectedValid
        partBeingCollected = ""
        partBeingCollectedValid = false
    }

    for (rowIndex in gameMatrix.indices) {
        val row = gameMatrix[rowIndex]
        for (colIndex in row.indices) {
            val col = row[colIndex]
            if (col.isDigit()) {
                partBeingCollected += col
                if (!partBeingCollectedValid) {
                    partBeingCollectedValid = isValidAround(gameMatrix, rowIndex, colIndex)
                }
            } else if (partBeingCollected.isNotEmpty()) {
                finalizeEndOfNumber()
            }
        }
        if (partBeingCollected.isNotEmpty()) {
            finalizeEndOfNumber()
        }
    }


    return partNumbers.zip(partValid).filter { it.second }.sumOf { it.first }
}

fun solvePart2(file: File): Int {
    return 0
}
