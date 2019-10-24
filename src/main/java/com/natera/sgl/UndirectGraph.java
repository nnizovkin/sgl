package com.natera.sgl;

public class UndirectGraph<Vertex> extends AbstractUndirectGraph<Vertex> {
    public boolean addEdge(Vertex start, Vertex end) {
        return super.addEdge(start, end, DEFAULT_WEIGHT);
    }
}
