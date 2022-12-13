import day01.solveDay1Part1Puzzle
import day01.solveDay1Part2Puzzle
import day02.solveDay2Part1Puzzle
import day02.solveDay2Part2Puzzle
import day03.solveDay3Part1Puzzle
import day03.solveDay3Part2Puzzle
import day04.solveDay4Part1Puzzle
import day04.solveDay4Part2Puzzle
import day05.solveDay5Part1Puzzle
import day05.solveDay5Part2Puzzle
import day06.solveDay6Part1Puzzle
import day06.solveDay6Part2Puzzle
import day07.solveDay7Part1Puzzle
import day07.solveDay7Part2Puzzle
import day08.solveDay8Part1Puzzle
import day08.solveDay8Part2Puzzle
import day09.solveDay9Part1Puzzle
import day09.solveDay9Part2Puzzle
import day10.solveDay10Part1Puzzle
import day10.solveDay10Part2Puzzle
import day11.solveDay11Part1Puzzle
import day11.solveDay11Part2Puzzle
import day12.solveDay12Part1Puzzle
import day12.solveDay12Part2Puzzle
import java.io.File

fun main() {
    println("Day01")
    println("Part1: ${solveDay1Part1Puzzle(File("src/main/kotlin/day01/input"))}")
    println("Part2: ${solveDay1Part2Puzzle(File("src/main/kotlin/day01/input"))}")

    println("Day02")
    println("Part1: ${solveDay2Part1Puzzle(File("src/main/kotlin/day02/input"))}")
    println("Part2: ${solveDay2Part2Puzzle(File("src/main/kotlin/day02/input"))}")

    println("Day03")
    println("Part1: ${solveDay3Part1Puzzle(File("src/main/kotlin/day03/input"))}")
    println("Part2: ${solveDay3Part2Puzzle(File("src/main/kotlin/day03/input"))}")

    println("Day04")
    println("Part1: ${solveDay4Part1Puzzle(File("src/main/kotlin/day04/input"))}")
    println("Part2: ${solveDay4Part2Puzzle(File("src/main/kotlin/day04/input"))}")

    println("Day05")
    println("Part1: ${solveDay5Part1Puzzle(File("src/main/kotlin/day05/input"))}")
    println("Part2: ${solveDay5Part2Puzzle(File("src/main/kotlin/day05/input"))}")

    println("Day06")
    println("Part1: ${solveDay6Part1Puzzle(File("src/main/kotlin/day06/input"))}")
    println("Part1: ${solveDay6Part2Puzzle(File("src/main/kotlin/day06/input"))}")

    println("Day07")
    println("Part1: ${solveDay7Part1Puzzle(File("src/main/kotlin/day07/input"))}") // 1307902
    println("Part2: ${solveDay7Part2Puzzle(File("src/main/kotlin/day07/input"))}") // 1307902

    println("Day08")
    println("Part1: ${solveDay8Part1Puzzle(File("src/main/kotlin/day08/input"))}")
    println("Part2: ${solveDay8Part2Puzzle(File("src/main/kotlin/day08/input"))}")

    println("Day09")
    println("Part1: ${solveDay9Part1Puzzle(File("src/main/kotlin/day09/input"))}")
    println("Part2: ${solveDay9Part2Puzzle(File("src/main/kotlin/day09/input"))}")

    println("Day10")
    println("Part1: ${solveDay10Part1Puzzle(File("src/main/kotlin/day10/input"))}")
    println("Part1:")
    println(solveDay10Part2Puzzle(File("src/main/kotlin/day10/input")))

    println("Day11")
    println("Part1: ${solveDay11Part1Puzzle(File("src/main/kotlin/day11/input"))}")
    println("Part2: ${solveDay11Part2Puzzle(File("src/main/kotlin/day11/input"))}")

    println("Day12")
    println("Part1: ${solveDay12Part1Puzzle(File("src/main/kotlin/day12/input"))}")
    println("Part2: ${solveDay12Part2Puzzle(File("src/main/kotlin/day12/input"))}")
}
