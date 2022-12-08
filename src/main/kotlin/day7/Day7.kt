package day7

import java.io.File

data class Crawler(val dir: String, val files: Map<String, Int>)

data class Node(val name: String, val nodes: List<Node>, val fileSize: Int, val recSize: Int)

fun createNode(name: String, files: List<Pair<String, Int>>): Node {
    val (dir, baseFiles) = files.toList().partition { it.first.contains("/") }
    val subDir = dir.groupBy { it.first.split("/").first() }
        .map { (a, b) -> a to b.map { it.copy(first = it.first.drop(a.length + 1)) } }
    val children: List<Node> = subDir.map { createNode(it.first, it.second) }
    val fileSize = baseFiles.sumOf { it.second }
    return Node(name, children, fileSize, fileSize + children.sumOf(Node::recSize))
}

fun computeSize(node: Node): Int {
    val childrenSize = node.nodes.sumOf { computeSize(it) }
    return if (node.recSize < 100000) node.recSize + childrenSize else childrenSize
}

fun solveDay7Part1Puzzle(file: File): Int {
    val rootNode = parseProblem(file)
    return rootNode.nodes.sumOf(::computeSize)
}

fun getDirSizes(node: Node): List<Int> {
    return node.nodes.flatMap { getDirSizes(it) } + node.recSize
}

fun solveDay7Part2Puzzle(file: File): Int {
    val rootNode = parseProblem(file)
    return getDirSizes(rootNode).sorted().first { rootNode.recSize - it < 30000000 }
}

fun parseProblem(file: File): Node {
    val files: Map<String, Int> = file
        .readLines()
        .joinToString(
            "\n"
        ).split("$ ")
        .filter(String::isNotEmpty)
        .fold(Crawler("", mapOf())) { acc, value ->
            val commands = value.split("\n")
            when {
                commands.first() == "cd /" -> return@fold acc.copy(dir = "")
                commands.first() == "cd .." -> return@fold acc.copy(
                    dir = "${acc.dir.split("/").dropLast(2).joinToString("/")}/"
                )
                commands.first().startsWith("cd ") -> return@fold acc.copy(
                    dir = "${acc.dir}${
                    commands.first().split(" ")[1]
                    }/"
                )
                else -> acc.copy(
                    files = acc.files + commands.drop(1).filter { !it.startsWith("dir") && it.isNotBlank() }.map {
                        acc.dir + it.split(" ")[1] to it.split(" ").first().toInt()
                    }
                )
            }
        }.files

    return createNode("root", files.toList())
}
