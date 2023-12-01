package day01

import java.io.File

fun solveDay1Part1Puzzle(file: File): Int {
    return file
        .readLines()
        .map { "${it.first(Char::isDigit)}${it.last(Char::isDigit)}" }
        .map(String::toInt)
        .sum()
}