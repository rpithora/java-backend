package com.shaurya._15graph;

import java.util.*;

class Edge{

    String source;
    String destination;

    public Edge(String source, String destination){
        this.source = source;
        this.destination = destination;
    }
}

class Graph{
    Map<String, List<String>> adjList = new HashMap<>();

    public Graph(List<Edge> edges){
        for(Edge edge : edges){
            String source = edge.source;
            String destination = edge.destination;
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.putIfAbsent(destination, new ArrayList<>());
            adjList.get(source).add(destination);

            // If this was undirected graph
            //adjList.get(destination).add(source);
        }
    }
}
public class GraphTraversal {

    public static void main(String[] args) {

        List<Edge> edges = Arrays.asList(
                new Edge("a", "b"), new Edge("a", "c"), new Edge("b", "d"), new Edge("c", "e"),
                new Edge("e", "b"), new Edge("f", "d"));

        Graph graph = new Graph(edges);

        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.print(graph);
        graphTraversal.bfs(graph, "a");
        graphTraversal.dfs(graph, "a");
        graphTraversal.dfsRec(graph, "a");
    }

    public void print(Graph graph) {
        Set<String> entrySet = graph.adjList.keySet();
        for (String src : entrySet) {
            if (graph.adjList.get(src).isEmpty()) {
                System.out.print("(" + src + " ——> " + graph.adjList.get(src) + ")\t");
            }else {
                for (String dest : graph.adjList.get(src)) {
                    System.out.print("(" + src + " ——> " + dest + ")\t");
                }
            }
            System.out.println();
        }
    }

    private void bfs(Graph graph, String node) {
        Queue<String> q = new LinkedList<>();
        q.offer(node);
        HashMap<String, Boolean> visited = new HashMap<>();
        while (!q.isEmpty()){
            String tempNode = q.poll();
            System.out.print(tempNode + " ");
            for(String neighbour : graph.adjList.get(tempNode)){
                if(null == visited.get(neighbour) || !visited.get(neighbour)){
                    if(!q.contains(neighbour)){
                        q.offer(neighbour);
                    }
                }
            }
            visited.put(tempNode,true);
        }
        System.out.println();
    }

    Set<String> visited = new HashSet<>();
    private void dfsRec(Graph graph, String node){
        System.out.print(node + " ");
        for(String neighbour : graph.adjList.get(node)){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                dfsRec(graph, neighbour);
            }
        }
    }

    private void dfs(Graph graph, String node) {
        Stack<String> stack = new Stack<>();
        stack.add(node);
        Map<String,Boolean> visited = new HashMap<>();
        while (!stack.isEmpty()){
            String tempNode = stack.pop();
            System.out.print(tempNode + " ");
            for(String neighbour : graph.adjList.get(tempNode)){
                if(null == visited.get(neighbour) || !visited.get(neighbour)){
                    if(!stack.contains(neighbour)){
                        stack.add(neighbour);
                    }
                }
            }
            visited.put(tempNode,true);
        }
        System.out.println();
    }
}
