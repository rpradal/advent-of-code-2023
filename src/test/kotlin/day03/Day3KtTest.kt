package day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

internal class Day3KtTest {
    companion object {
        @JvmStatic
        fun generatePart1TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day03/sample", 4361),
                Arguments.of("src/test/kotlin/day03/puzzle", null),
            )
        }

        @JvmStatic
        fun generatePart2TestCases(): List<Arguments> {
            return listOf(
                Arguments.of("src/test/kotlin/day03/sample", null),
                Arguments.of("src/test/kotlin/day03/puzzle", null),
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
