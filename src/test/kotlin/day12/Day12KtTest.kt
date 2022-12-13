package day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day12KtTest {

    @Test
    fun solveDay12Part1Puzzle() {
        val testFile = File("src/test/kotlin/day12/sample")

        val result = solveDay12Part1Puzzle(testFile)

        assertEquals(31, result)
    }

    @Test
    fun solveDay12Part2Puzzle() {
        val testFile = File("src/test/kotlin/day12/sample")

        val result = solveDay12Part2Puzzle(testFile)

        assertEquals(29, result)
    }
}
