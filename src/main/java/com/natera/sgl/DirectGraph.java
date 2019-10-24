package com.natera.sgl;

public class DirectGraph<V> extends AbstractGraph<V> {
    public boolean addEdge(V start, V end) {
        return super.addEdge(start, end, DEFAULT_WEIGHT);
    }
}
