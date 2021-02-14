package com.ds.longlist.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Topological Sort Based on Arrival & Departure Time of Nodes : Using DFS
// Similar as logic of Arrival Departure time @ Graph vertices.

class Edge{
    Integer src;
    Integer dst;

    public Edge(Integer src, Integer dst) {
        this.src = src;
        this.dst = dst;
    }
}

class Graph{
    List<List<Integer>> adjList = null;

    public Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>();
        for(int i=0; i<N; i++){
            adjList.add(new ArrayList<>());
        }

        for(Edge e : edges){
            adjList.get(e.src).add(e.dst);
        }
    }
}

public class ArrivalDepartureTime {

    static int DFS(Graph graph, int vertex, boolean[] visited,
                   int[] depart, int time){
        visited[vertex] = true;
        time++; // Visited time

        for(Integer dst : graph.adjList.get(vertex)){
            if(!visited[dst]){
                time = DFS(graph, dst, visited, depart, time);
            }
        }

        depart[time] = vertex;
        time++; //Depart time // updated once backtracking started from other node.

        return time;
    }

    private static void doTopologicalSort(Graph graph, int N) {
        int[] depart = new int[2*N];
        Arrays.fill(depart, -1);

        boolean[] visited = new boolean[N];
        int time = 0;

        for(int i=0; i<N; i++){
            if(!visited[i]){
                time = DFS(graph, i, visited, depart, time);
            }
        }

        for(int i=2*N-1; i>=0; i--){
            if(depart[i] != -1)
                System.out.print(depart[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );


        // total number of nodes in the graph
        final int N = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, N);

        // perform topological sort
        doTopologicalSort(graph, N);
    }


}
