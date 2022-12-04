import day1.solveDay1Part1Puzzle
import day1.solveDay1Part2Puzzle
import day2.solveDay2Part1Puzzle
import day2.solveDay2Part2Puzzle
import day3.solveDay3Part1Puzzle
import day3.solveDay3Part2Puzzle
import day4.solveDay4Part1Puzzle
import day4.solveDay4Part2Puzzle
import java.io.File

fun main() {
    println("Day1")
    println("Part1: ${solveDay1Part1Puzzle(File("src/main/kotlin/day1/input"))}")
    println("Part2: ${solveDay1Part2Puzzle(File("src/main/kotlin/day1/input"))}")

    println("Day2")
    println("Part1: ${solveDay2Part1Puzzle(File("src/main/kotlin/day2/input"))}")
    println("Part2: ${solveDay2Part2Puzzle(File("src/main/kotlin/day2/input"))}")

    println("Day3")
    println("Part1: ${solveDay3Part1Puzzle(File("src/main/kotlin/day3/input"))}")
    println("Part2: ${solveDay3Part2Puzzle(File("src/main/kotlin/day3/input"))}")

    println("Day4")
    println("Part1: ${solveDay4Part1Puzzle(File("src/main/kotlin/day4/input"))}")
    println("Part2: ${solveDay4Part2Puzzle(File("src/main/kotlin/day4/input"))}")
}

