package day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day8KtTest {

    @Test
    fun solveDay8Part1Puzzle() {
        val testFile = File("src/test/kotlin/day08/sample")

        val result = solveDay8Part1Puzzle(testFile)

        assertEquals(21, result)
    }

    @Test
    fun solveDay8Part2Puzzle() {
        val testFile = File("src/test/kotlin/day08/sample")

        val result = solveDay8Part2Puzzle(testFile)

        assertEquals(8, result)
    }
}
