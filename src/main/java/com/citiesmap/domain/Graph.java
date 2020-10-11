package com.citiesmap.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import lombok.NonNull;

/**
 * A mathematical graph-theory object G(V,E) contains a set of V of vertices and
 * a set of E of edges. Each edge e=(v1,v2) in E connects vertex v1 to vertex
 * v2. This class implements an undirected graph.
 * 
 * @author ssondhiya
 *
 * @param <T> Type of vertex. Given type must follow these rules:<br>
 *            <ul>
 *            <li>It must override equals and hashCode methods</li>
 *            <li>Your implementation for hashCode must produce a value which
 *            does not change over the lifetime of the object</li>
 *            </ul>
 */
public final class Graph<T> {

	private Map<T, Set<T>> graph;

	public Graph() {
		graph = new HashMap<>();
	}

	/**
	 * Add a vertex. Adding a duplicate vertex is not an error, but the duplicate is
	 * discarded.
	 * 
	 * @param vertex A vertex to be added in graph.
	 */
	public void addIfAbsent(@NonNull final T vertex) {
		graph.putIfAbsent(vertex, new HashSet<>());
	}

	/**
	 * Add an undirected edge. Adding a duplicate edge is not an error, but the
	 * duplicate is discarded.
	 * 
	 * @param vertex1
	 * @param vertex2
	 */
	public void addUndirectedEdge(@NonNull final T vertex1, @NonNull final T vertex2) {
		graph.get(vertex1).add(vertex2);
		graph.get(vertex2).add(vertex1);
	}

	/**
	 * Check if two vertex is connected. It uses Breadth-First Traversal algorithm
	 * to find the connection.
	 * 
	 * @param origin      Origin vertex.
	 * @param destination Destination vertex.
	 * @return True if connected else False.
	 */
	public boolean isConnected(@NonNull final T origin, @NonNull final T destination) {
		if (origin.equals(destination)) {
			return true;
		}
		Set<T> visited = new LinkedHashSet<>();
		Queue<T> queue = new LinkedList<>();
		queue.add(origin);
		visited.add(origin);
		while (!queue.isEmpty()) {
			T vertex = queue.poll();
			for (T adjVertex : graph.get(vertex)) {
				if (adjVertex.equals(destination)) {
					return true;
				}
				if (!visited.contains(adjVertex)) {
					queue.add(adjVertex);
					visited.add(adjVertex);
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return graph.toString();
	}
}
