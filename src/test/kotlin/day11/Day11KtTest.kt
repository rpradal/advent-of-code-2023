package day11

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Day11KtTest {

    @Test
    fun solveDay11Part1Puzzle() {
        val testFile = File("src/test/kotlin/day11/sample")

        val result = solveDay11Part1Puzzle(testFile)

        assertEquals(10605, result)
    }

    @Test
    fun solveDay11Part2Puzzle() {
        val testFile = File("src/test/kotlin/day11/sample")

        val result = solveDay11Part2Puzzle(testFile)

        assertEquals(2713310158, result)
    }
}