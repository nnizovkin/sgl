package com.natera.sgl;

public class WeightedDirectGraph<Vertex> extends AbstractGraph<Vertex> {
    public boolean addEdge(Vertex start, Vertex end, double weight) {
        return super.addEdge(start, end, weight);
    }
}
