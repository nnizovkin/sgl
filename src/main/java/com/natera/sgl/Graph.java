package com.natera.sgl;

import java.util.Set;

public interface Graph<Vertex> {
    boolean containsVertex(Vertex vertex);
    Set<Edge<Vertex>> getAdjacencyList(Vertex vertex);
}
