package com.natera.sgl;

public class UndirectGraph<T> extends Graph<T> {
    @Override
    public boolean addEdge(T start, T end) {
        return super.addEdge(start, end) && super.addEdge(end, start);
    }
}
