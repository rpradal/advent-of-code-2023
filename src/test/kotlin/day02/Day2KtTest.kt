package day02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

internal class Day2KtTest {
    companion object {
        @JvmStatic
        fun generatePart1TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day02/sample", 8),
                Arguments.of("src/test/kotlin/day02/puzzle", 1931),
            )
        }

        @JvmStatic
        fun generatePart2TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day02/sample", 2286),
                Arguments.of("src/test/kotlin/day02/puzzle", 83105),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("generatePart1TestCases")
    fun solvePart1Puzzle(
        path: String,
        expectedResult: Int,
    ) {
        val testFile = File(path)

        val result = solvePart1(testFile)

        assertEquals(expectedResult, result)
    }

    @ParameterizedTest
    @MethodSource("generatePart2TestCases")
    fun solvePart2Puzzle(
        path: String,
        expectedResult: Int,
    ) {
        val testFile = File(path)

        val result = solvePart2(testFile)

        assertEquals(expectedResult, result)
    }
}
