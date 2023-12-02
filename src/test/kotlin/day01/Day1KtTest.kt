package day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

internal class Day1KtTest {
    companion object {
        @JvmStatic
        fun generatePart1TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day01/sample_part1", 142),
                Arguments.of("src/test/kotlin/day01/puzzle", 56506),
            )
        }

        @JvmStatic
        fun generatePart2TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day01/sample_part2", 281),
                Arguments.of("src/test/kotlin/day01/puzzle", 56017),
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
