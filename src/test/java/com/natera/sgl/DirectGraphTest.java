package com.natera.sgl;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class DirectGraphTest {
    @Test
    public void addVertexTest() {
        DirectGraph<String> graph = new DirectGraph<>();
        assertTrue(graph.addVertex("A"));
        assertFalse(graph.addVertex("A"));
        assertTrue(graph.addVertex("B"));
        assertFalse(graph.addVertex("A"));
    }

    @Test
    public void addEdgeTest() {
        DirectGraph<String> graph = new DirectGraph<>();
        assertFalse(graph.addEdge("A", "B"));
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.addEdge("A", "B"));
        assertFalse(graph.addEdge("A", "C"));
    }


    @Test
    public void getPathTestOne() {
        DirectGraph<Integer> graph = new DirectGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);

        assertEquals(Arrays.asList(1, 2, 3), graph.getPath(1, 3));
        assertEquals(Arrays.asList(1, 2), graph.getPath(1, 2));
        assertEquals(Arrays.asList(2, 3), graph.getPath(2, 3));
        assertEquals(Collections.singletonList(1), graph.getPath(1, 1));
        assertNull(graph.getPath(1, 0));
        assertNull(graph.getPath(1, 4));
    }

    @Test
    public void getPathTestTwo() {
        DirectGraph<Integer> graph = new DirectGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        assertEquals(Arrays.asList(1, 3, 5), graph.getPath(1, 5));
        assertEquals(Arrays.asList(1, 2), graph.getPath(1, 2));
        assertEquals(Arrays.asList(1, 3), graph.getPath(1, 3));
        assertNull(graph.getPath(2, 3));
    }

    @Test
    public void getPathTestThree() {
        DirectGraph<Integer> graph = new DirectGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 4);

        assertEquals(Arrays.asList(1, 2), graph.getPath(1, 2));
        assertEquals(Collections.singletonList(1), graph.getPath(1, 1));
        assertEquals(Arrays.asList(1, 3), graph.getPath(1, 3));
        assertEquals(Arrays.asList(1, 4), graph.getPath(1, 4));
    }

    @Test
    public void getPathTestFour() {
        DirectGraph<Integer> graph = new DirectGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);

        assertEquals(Arrays.asList(1, 4, 5, 3), graph.getPath(1, 3));
    }
}
