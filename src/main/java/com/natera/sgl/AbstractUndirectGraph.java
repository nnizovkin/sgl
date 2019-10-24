package com.natera.sgl;

public class AbstractUndirectGraph<Vertex> extends AbstractGraph<Vertex> {
    public boolean addEdge(Vertex start, Vertex end, double weight) {
        return super.addEdge(start, end, weight) && super.addEdge(end, start, weight);
    }
}