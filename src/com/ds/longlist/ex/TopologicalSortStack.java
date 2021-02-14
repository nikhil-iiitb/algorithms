package com.ds.longlist.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortStack {

    private static void topologicalSort(Graph g, int N) {
        Stack<Integer> gStack = new Stack<>();
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        for(int i=0; i<N; i++){
            if(!visited[i]){
                topologicalUtil(g, gStack, i, visited, N);
            }
        }

        while (!gStack.isEmpty()){
            System.out.print(gStack.pop() + " ");
        }
    }

    private static void topologicalUtil(Graph g, Stack<Integer> gStack, int vertex,
                                        boolean[] visited, int n) {

        visited[vertex] = true;

        for(Integer dst : g.adjList.get(vertex)){
            if(!visited[dst]){
                topologicalUtil(g, gStack, dst, visited, n);
            }
        }
        gStack.push(vertex);
    }

    public static void main(String args[])
    {

        List<Edge> edges = Arrays.asList(
                new Edge(5, 2), new Edge(4, 0),
                new Edge(2, 3), new Edge(5, 0),
                new Edge(4, 0), new Edge(3, 1)
        );

        int N = 6;
        Graph g = new Graph(edges, N);

        System.out.println("Following is a Topological "
                + "sort of the given graph");

        topologicalSort(g, N);
    }


}
