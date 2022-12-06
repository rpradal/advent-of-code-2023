package day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.File


internal class Day6KtTest {

    @ParameterizedTest
    @CsvSource(
        "sample1, 5",
        "sample2, 6",
        "sample3, 10",
        "sample4, 11",
    )
    fun solveDay6Part1Puzzle(sampleFileName: String, expectedResult: String) {
        val testFile = File("src/test/kotlin/day6/${sampleFileName}")

        val result = solveDay6Part1Puzzle(testFile)

        Assertions.assertEquals(expectedResult.toInt(), result)
    }

    @ParameterizedTest
    @CsvSource(
        "sample1, 23",
        "sample2, 23",
        "sample3, 29",
        "sample4, 26",
    )
    fun solveDay6Part2Puzzle(sampleFileName: String, expectedResult: String) {
        val testFile = File("src/test/kotlin/day6/${sampleFileName}")

        val result = solveDay6Part2Puzzle(testFile)

        Assertions.assertEquals(expectedResult.toInt(), result)
    }
}