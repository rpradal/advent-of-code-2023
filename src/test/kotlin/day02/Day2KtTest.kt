package day02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2KtTest {

    @Test
    fun solveDay2Part1Puzzle() {
        val testFile = File("src/test/kotlin/day2/sample")

        val result = solveDay2Part1Puzzle(testFile)

        assertEquals(15, result)
    }

    @Test
    fun solveDay1Part2Puzzle() {
        val testFile = File("src/test/kotlin/day2/sample")

        val result = solveDay2Part2Puzzle(testFile)

        assertEquals(12, result)
    }
}
