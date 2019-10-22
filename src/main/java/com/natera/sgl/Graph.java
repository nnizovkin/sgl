package com.natera.sgl;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Graph<T> {
    private final Map<T, Integer> vertexMapping = new HashMap<>();
    private final Map<Integer, T> invertedVertexMapping = new HashMap<>();
    private final ArrayList<Set<Integer>> adjacencyList = new ArrayList<>();
    public boolean addVertex(T vertex) {
        if(vertexMapping.containsKey(vertex)) {
            return false;
        }

        adjacencyList.add(new HashSet<>());
        vertexMapping.put(vertex, adjacencyList.size() - 1);
        invertedVertexMapping.put(adjacencyList.size() - 1, vertex);

        return true;
    }

    public boolean addEdge(T start, T end) {
        Integer startIndex = vertexMapping.get(start);
        Integer endIndex = vertexMapping.get(end);
        if(startIndex == null
                || endIndex == null) {
            return false;
        }

        adjacencyList.get(startIndex).add(endIndex);

        return true;
    }

    public List<T> getPath(T start, T end) {
        Integer startIndex = vertexMapping.get(start);
        Integer endIndex = vertexMapping.get(end);
        if(startIndex == null
                || endIndex == null) {
            return null;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        stack.push(startIndex);

        Set<Integer> usedVertexes = new HashSet<>();
        usedVertexes.add(startIndex);

        while(!stack.isEmpty() && !stack.peekFirst().equals(endIndex)) {
            Integer index = stack.peekFirst();
            if(result.isEmpty() || !result.peekLast().equals(index)) {
                result.offerLast(index);
            }
            boolean addAny = false;
            for(Integer newVertex: adjacencyList.get(index)) {
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

        result.offerLast(endIndex);

        if(stack.isEmpty()) {
            return null;
        }


        return result.stream().map(invertedVertexMapping::get).collect(Collectors.toList());
    }
}
