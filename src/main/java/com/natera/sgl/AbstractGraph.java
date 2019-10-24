package com.natera.sgl;

import java.util.*;

public abstract class AbstractGraph<Vertex> implements Graph<Vertex> {
    public static final double DEFAULT_WEIGHT = 1;
    private final Map<Vertex, Set<Edge<Vertex>>> adjacencyLists = new HashMap<>();
    public boolean addVertex(Vertex vertex) {
        if(adjacencyLists.containsKey(vertex)) {
            return false;
        }

        adjacencyLists.put(vertex, new HashSet<>());

        return true;
    }

    protected boolean addEdge(Vertex start, Vertex end, double weight) {
        if(!adjacencyLists.containsKey(start)
                || !adjacencyLists.containsKey(end)) {
            return false;
        }

        Edge<Vertex> edge = new Edge<>(start, end, weight);
        Set<Edge<Vertex>> edges = adjacencyLists.get(start);

        //linear operation, impl useful for
        if(edges.contains(edge)) {
            return true;
        }

        edges.add(edge);
        return true;
    }

    public boolean containsVertex(Vertex vertex) {
        return adjacencyLists.containsKey(vertex);
    }

    public Set<Edge<Vertex>> getAdjacencyList(Vertex vertex) {
        return adjacencyLists.get(vertex);
    }
}
