package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintPath {

     static class Edge{
        int src, nbr, wt;
        Edge(int s, int d, int wt){
            this.src = s;
            this.nbr = d;
            this.wt = wt;
        }
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ver = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[ver];
        for(int i = 0; i < ver; i++){
            graph[i] = new ArrayList();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i< edges; i++){
            String[] parts = br.readLine().split("" );
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int s = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[ver];
        boolean path = hasPath(graph, s, d, visited);



    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){

        if(src == dest){
            return true;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){

            if(!visited[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasNbrPath) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String ans){

        if(src == dest){
            System.out.println(ans);
        }

        visited[src] = true;
        for(Edge edge : graph[src]){

            if(!visited[edge.nbr]) {
                allPath(graph, edge.nbr, dest, visited, ans + edge.nbr);
            }

        }
        visited[src] = false;

    }
}
