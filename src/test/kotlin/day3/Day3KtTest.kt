package day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Day3KtTest {

    @Test
    fun solveDay3Part1Puzzle() {
        val testFile = File("src/test/kotlin/day3/sample")

        val result = solveDay3Part1Puzzle(testFile)

        assertEquals(157, result)
    }

    @Test
    fun solveDay3Part2Puzzle() {
        val testFile = File("src/test/kotlin/day3/sample")

        val result = solveDay3Part2Puzzle(testFile)

        assertEquals(70, result)
    }
}