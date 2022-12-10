package day04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4KtTest {

    @Test
    fun solveDay4Part1Puzzle() {
        val testFile = File("src/test/kotlin/day04/sample")

        val result = solveDay4Part1Puzzle(testFile)

        assertEquals(2, result)
    }

    @Test
    fun solveDay4Part2Puzzle() {
        val testFile = File("src/test/kotlin/day04/sample")

        val result = solveDay4Part2Puzzle(testFile)

        assertEquals(4, result)
    }
}
