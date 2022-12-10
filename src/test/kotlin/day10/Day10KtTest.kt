package day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day10KtTest {

    @Test
    fun solveDay10Part1Puzzle() {
        val testFile = File("src/test/kotlin/day10/sample")

        val result = solveDay10Part1Puzzle(testFile)

        assertEquals(13140, result)
    }

    @Test
    fun solveDay10Part2Puzzle() {
        val testFile = File("src/test/kotlin/day10/sample")

        val result = solveDay10Part2Puzzle(testFile)

        assertEquals(
            """
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######.....
            """.trimIndent(),
            result
        )
    }
}
