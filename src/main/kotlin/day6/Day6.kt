package day6

import java.io.File

fun solveDay6Part1Puzzle(file: File): Int {
    return firstMarker(file, 4)

}

fun solveDay6Part2Puzzle(file: File): Int {
    return firstMarker(file, 14)
}


fun firstMarker(file: File, distinctCharCount: Int): Int {
    return file
        .readLines()
        .first()
        .toList()
        .windowed(distinctCharCount)
        .map(List<Char>::distinct)
        .map(List<Char>::size)
        .withIndex()
        .maxBy(IndexedValue<Int>::value)
        .index + distinctCharCount
}