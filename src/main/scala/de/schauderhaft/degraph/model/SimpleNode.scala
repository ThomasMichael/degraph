package de.schauderhaft.degraph.model

sealed trait Node {
    def contains(n: Node): Boolean
    def types: Set[String]
}

/**
 * represents a node in the dependency graph.
 */
case class SimpleNode(
    nodeType: String,
    name: String) extends Node {

    def contains(n: Node) = (this == n)
    def types = Set(nodeType)
}

case class ParentAwareNode(vals: Node*) extends Node {
    def prune = if (vals.size == 1) vals.head else this
    def next = if (vals.size > 1) new ParentAwareNode(vals.tail: _*) else this
    def head = vals.head

    def contains(n: Node) = (vals.exists(_.contains(n)))
    def types = vals.flatMap(_.types).toSet
}
