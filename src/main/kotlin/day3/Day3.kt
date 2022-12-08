package day3

import java.io.File

fun solveDay3Part1Puzzle(file: File): Int {
    return file.readLines().map {
        it.subSequence(0, it.length / 2).toList() to it.subSequence(it.length / 2, it.length).toList()
    }.map {
        it.first.toSet().intersect(it.second.toSet())
    }.flatten()
        .sumOf(::computeCharValue)
}

fun solveDay3Part2Puzzle(file: File): Int {
    return file.readLines()
        .map(String::toList)
        .chunked(3)
        .map { it.map(List<Char>::toSet) }
        .map {
            it.reduce { acc, chars -> acc.intersect(chars) }
        }.flatten()
        .sumOf(::computeCharValue)
}

fun computeCharValue(char: Char): Int {
    return if (char in 'A'..'Z') char - 'A' + 27 else char - 'a' + 1
}
