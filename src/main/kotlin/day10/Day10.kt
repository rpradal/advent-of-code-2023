package day10

import java.io.File

sealed class Instruction(open val value: Int) {
    object NOOP : Instruction(0)
    data class ADD(override val value: Int) : Instruction(value)

    companion object {
        fun fromString(stringRepresentation: String): Instruction {
            return when {
                stringRepresentation == "noop" -> NOOP
                stringRepresentation.startsWith("addx ") -> ADD(stringRepresentation.split(" ")[1].toInt())
                else -> throw IllegalArgumentException()
            }
        }
    }
}

private const val CRT_SIZE = 40

fun solveDay10Part1Puzzle(file: File): Int {
    return cycleToRegistryValue(file)
        .filter { it.first in (20..220 step CRT_SIZE).toList() }
        .map { it.first * it.second }
        .sum()
}

private fun cycleToRegistryValue(file: File) = file
    .readLines()
    .map(Instruction::fromString)
    .flatMap(::flattenInstruction)
    .scan(1) { acc, instruction -> acc + instruction.value }
    .mapIndexed { index, registerValue -> (index + 1) to registerValue }
    .dropLast(1)

fun solveDay10Part2Puzzle(file: File): String {
    return cycleToRegistryValue(file)
        .chunked(CRT_SIZE)
        .mapIndexed { index, pairs -> pairs.map { (it.first - CRT_SIZE * index) to it.second } }
        .map { row -> row.map { if (it.first in it.second..it.second + 2) "#" else "." } }
        .joinToString("\n") { it.joinToString("") }
}

private fun flattenInstruction(instruction: Instruction) = when (instruction) {
    Instruction.NOOP -> listOf(instruction)
    is Instruction.ADD -> listOf(Instruction.NOOP, instruction)
}
