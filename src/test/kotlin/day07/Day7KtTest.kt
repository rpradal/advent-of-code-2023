package day07

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day7KtTest {

    @Test
    fun solveDay7Part1Puzzle() {
        val testFile = File("src/test/kotlin/day07/sample")

        val result = solveDay7Part1Puzzle(testFile)

        assertEquals(95437, result)
    }

    @Test
    fun solveDay7Part2Puzzle() {
        val testFile = File("src/test/kotlin/day07/sample")

        val result = solveDay7Part2Puzzle(testFile)

        assertEquals(24933642, result)
    }
}
