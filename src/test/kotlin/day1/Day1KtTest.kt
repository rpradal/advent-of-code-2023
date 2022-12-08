package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1KtTest {

    @Test
    fun solveDay1Part1Puzzle() {
        val testFile = File("src/test/kotlin/day1/sample")

        val result = solveDay1Part1Puzzle(testFile)

        assertEquals(24000, result)
    }

    @Test
    fun solveDay1Part2Puzzle() {
        val testFile = File("src/test/kotlin/day1/sample")

        val result = solveDay1Part2Puzzle(testFile)

        assertEquals(45000, result)
    }
}
