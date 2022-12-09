package day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day9KtTest {

    @Test
    fun solveDay9Part1Puzzle() {
        val testFile = File("src/test/kotlin/day9/sample")

        val result = solveDay9Part1Puzzle(testFile)

        assertEquals(13, result)
    }
}
