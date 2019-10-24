package com.natera.sgl;

public class WeightedUndirectGraph<Vertex> extends AbstractUndirectGraph<Vertex> {
    public boolean addEdge(Vertex start, Vertex end, double weight) {
        return super.addEdge(start, end, weight);
    }
}
