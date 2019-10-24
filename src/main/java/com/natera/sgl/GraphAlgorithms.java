package com.natera.sgl;

import java.util.*;

public class GraphAlgorithms {
    public <Vertex> List<Vertex> getPath(Graph<Vertex> graph, Vertex start, Vertex end) {
        if(!graph.containsVertex(start)
                || !graph.containsVertex(end)) {
            return null;
        }

        Deque<Vertex> stack = new ArrayDeque<>();
        Deque<Vertex> result = new ArrayDeque<>();
        stack.push(start);

        Set<Vertex> usedVertexes = new HashSet<>();
        usedVertexes.add(start);

        while(!stack.isEmpty() && !stack.peekFirst().equals(end)) {
            Vertex vertex = stack.peekFirst();
            if(result.isEmpty() || !result.peekLast().equals(vertex)) {
                result.offerLast(vertex);
            }
            boolean addAny = false;
            for(Edge<Vertex> newEdge: graph.getAdjacencyList(vertex)) {
                Vertex newVertex = newEdge.end;
                if(!usedVertexes.contains(newVertex)) {
                    stack.push(newVertex);
                    usedVertexes.add(newVertex);
                    addAny = true;
                }
            }

            if(!addAny) {
                stack.pop();
                result.pollLast();
            }
        }

        result.offerLast(end);

        if(stack.isEmpty()) {
            return null;
        }


        return new ArrayList<>(result);
    }
}
