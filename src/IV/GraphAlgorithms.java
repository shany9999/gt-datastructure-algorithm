package IV;

import java.util.*;

/**
 * Your implementation of various graph traversal algorithms.
 */

/**
 * Your implementation of Prim's algorithm.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visitedSet = new HashSet<>();
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();
        List<Vertex<T>> result = new ArrayList<>();
        visitedSet.add(start);
        queue.add(start);
        Vertex<T> v;
        while (queue.peek() != null){
            v = queue.remove();
            result.add(v);
            List<VertexDistance<T>> neighbor = adjList.get(v);
            for (VertexDistance<T> w: neighbor){
                if (!visitedSet.contains(w.getVertex())){
                    visitedSet.add(w.getVertex());
                    queue.add(w.getVertex());
                }
            }
        }

        return result;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visitedSet = new HashSet<>();
        List<Vertex<T>> result = new ArrayList<>();
        return dfs_h(start, graph, visitedSet, result);
    }

    private static <T> List<Vertex<T>> dfs_h(Vertex<T> node, Graph<T> graph, Set<Vertex<T>> visitedSet, List<Vertex<T>> result){
        visitedSet.add(node);
        result.add(node);
        List<VertexDistance<T>> neighbor = graph.getAdjList().get(node);
        for (VertexDistance<T> w: neighbor){
            if (!visitedSet.contains(w.getVertex())){
                dfs_h(w.getVertex(), graph, visitedSet, result);
            }
        }
        return result;
    }


    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int num_vertices = graph.getVertices().size();
        Set<Vertex<T>> visited_set = new HashSet<>();
        Set<Edge<T>> edge_set = new HashSet<>();
        PriorityQueue<Edge<T>> queue = new PriorityQueue<>();

        for (VertexDistance<T> vd : graph.getAdjList().get(start)){
            queue.add(new Edge(start, vd.getVertex(), vd.getDistance()));
        }
        visited_set.add(start);
        while (queue.peek() != null && visited_set.size() < num_vertices){
            Edge<T> adj = queue.poll();
            Vertex<T> u = adj.getU();
            Vertex<T> v = adj.getV();
            if (!visited_set.contains(v)){
                visited_set.add(v);
                edge_set.add(adj);
                edge_set.add(new Edge(v, u, adj.getWeight()));
                for (VertexDistance<T> vd : graph.getAdjList().get(v)){
                    Vertex<T> w = vd.getVertex();
                    if (!visited_set.contains(w)){
                        queue.add(new Edge(v, vd.getVertex(), vd.getDistance()));
                    }
                }
            }
        }
        if (visited_set.size() == num_vertices){
            return edge_set;
        }
        return null;

    }

}