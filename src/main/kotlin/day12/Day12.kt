package day12

import java.io.File

fun findCoordinate(puzzle: List<String>, target: Char): Pair<Int, Int> {
    puzzle.forEachIndexed { index, s ->
        val column = s.indexOf(target)
        if (column >= 0) {
            return index to column
        }
    }
    throw IllegalArgumentException()
}

fun parsePuzzle(puzzle: List<String>): List<List<Int>> {
    val basePuzzle: List<List<Int>> = puzzle.map {
        it.toList().map {
            when (it) {
                'S' -> 0
                'E' -> 25
                else -> it - 'a'
            }
        }
    }
    return basePuzzle
}

data class Graph(
    val vertices: Set<Pair<Int, Int>>,
    val edges: Map<Pair<Int, Int>, Set<Pair<Int, Int>>>,
)

fun convertPuzzleToGraph(puzzle: List<List<Int>>, climbing: Boolean): Graph {
    val edges = puzzle.mapIndexed { indexRows, ints ->
        ints.mapIndexed Inner@{ indexColumns, value ->
            return@Inner Pair(indexRows, indexColumns) to setOf(
                Pair(indexRows - 1, indexColumns),
                Pair(indexRows + 1, indexColumns),
                Pair(indexRows, indexColumns + 1),
                Pair(indexRows, indexColumns - 1)
            )
                .filter { it.first in puzzle.indices && it.second in ints.indices }
                .filter { if (climbing) puzzle[it.first][it.second] - value <= 1 else value - puzzle[it.first][it.second] <= 1 }
                .toSet()
        }
    }.flatten().toMap()
    return Graph(
        vertices = edges.keys,
        edges = edges,
    )
}

fun dijkstra(graph: Graph, start: Pair<Int, Int>): Map<Pair<Int, Int>, Pair<Int, Int>?> {
    val S: MutableSet<Pair<Int, Int>> = mutableSetOf()

    val delta = graph.vertices.associateWith { Int.MAX_VALUE }.toMutableMap()
    delta[start] = 0

    val previous = graph.vertices.associateWith { null }.toMutableMap<Pair<Int, Int>, Pair<Int, Int>?>()

    while (S != graph.vertices) {
        val v: Pair<Int, Int> = delta
            .filter { !S.contains(it.key) }
            .minBy(Map.Entry<Pair<Int, Int>, Int>::value)
            .key

        graph.edges.getValue(v).minus(S).forEach { neighbor ->
            val newPath = delta.getValue(v) + 1

            if (newPath < delta.getValue(neighbor)) {
                delta[neighbor] = newPath
                previous[neighbor] = v
            }
        }

        S.add(v)
    }

    return previous
}

fun shortestPath(
    shortestPathTree: Map<Pair<Int, Int>, Pair<Int, Int>?>,
    start: Pair<Int, Int>,
    end: Pair<Int, Int>
): List<Pair<Int, Int>> {
    fun pathTo(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Pair<Int, Int>> {
        val pair = shortestPathTree[end]
        return if (pair == null) {
            listOf(end)
        } else {
            listOf(pathTo(start, pair), listOf(end)).flatten()
        }
    }

    return pathTo(start, end)
}

fun solveDay12Part1Puzzle(file: File): Int {
    val puzzle = file.readLines()
    val startCoordinate = findCoordinate(puzzle, 'S')
    val endCoordinate = findCoordinate(puzzle, 'E')
    val parsedPuzzle = parsePuzzle(puzzle)

    val graph = convertPuzzleToGraph(parsedPuzzle, true)
    return shortestPath(dijkstra(graph, startCoordinate), startCoordinate, endCoordinate).size - 1
}

fun solveDay12Part2Puzzle(file: File): Int {
    val puzzle = file.readLines()
    val endCoordinate = findCoordinate(puzzle, 'E')
    val parsedPuzzle = parsePuzzle(puzzle)
    val graph = convertPuzzleToGraph(parsedPuzzle, false)

    val shortestPathTree = dijkstra(graph, endCoordinate)
    return parsedPuzzle.mapIndexed { indexRows, ints ->
        ints.mapIndexed { indexColumns, value ->
            Pair(indexRows, indexColumns) to value
        }
    }
        .flatten()
        .filter { it.second == 0 }
        .map { it.first }
        .map { shortestPath(shortestPathTree, endCoordinate, it) }
        .filter { it.first() == endCoordinate }
        .minOf { it.size } - 1
}
