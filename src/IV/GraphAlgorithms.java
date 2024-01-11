package IV;

import java.util.*;

/**
 * Your implementation of various graph traversal algorithms.
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

}