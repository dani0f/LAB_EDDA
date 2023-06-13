import java.util.*;
import java.util.Queue;

public class Graph {
    private ArrayList<ArrayList<Integer>> adj;
    private final int V;
    private int E;
    private String cityNames[];


    public Graph(int V, String[] cityNames) {
        this.V = V;
        this.E = 0;
        this.cityNames = cityNames;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    //1 error
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        this.E ++;
    }

    public void printAdjacentList() {
        for (int i = 0; i < V; i++) {
            System.out.printf("V%s %s = [ ", i, cityNames[i]);
            for (int j : adj.get(i)) {
                System.out.printf("V%s ", j);
            }
            System.out.println("]");
        }
    }



    public static class DepthFirstPaths {
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;
        //Sin errores
        public DepthFirstPaths(Graph G, int s) {
            marked = new boolean[G.V];
            edgeTo = new int[G.V];
            this.s = s;
            dfs(G, s);
        }
        //Falta ingresar el camino en edgeTo
        //1 error
        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w : G.adj.get(v))
                if (marked[w]) {
                    dfs(G, w);
                }
        }
        //Completar
        public boolean hasPathTo(int v) {
            //implementar con marked
            return true;
        }

        //Completar
        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            //implementar con edgeTo
            return path;
        }
    }

    public static class BreadthFirstPaths
    {
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;
        //1 error
        public BreadthFirstPaths(Graph G, int s)
        {
            marked = new boolean[G.V];
            edgeTo = new int[G.V];
            this.s = s;
            bfs(G, s+1);
        }
        //Falta ingresar el camino en edgeTo
        private void bfs(Graph G, int s)
        {
            Queue<Integer> queue = new LinkedList<>();
            marked[s] = true;
            queue.offer(s);
            while (!queue.isEmpty())
            {
                int v = queue.poll();
                for (int w : G.adj.get(v))
                    if (!marked[w])
                    {
                        marked[w] = true;
                        queue.offer(w);
                    }
            }
        }
        //Completar
        public boolean hasPathTo(int v)
        {
            //implementar con marked
            return true;
        }
        //Completar
        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            //implementar con edgeTo
            return path;
        }
    }


    public static void main(String[] args) {
        String[] cityName = {"Santiago", "Valparaiso", "Vina del mar", "Rancagua", "Melipilla", "Pichilemu", "Bucalemu", "Talca", "Antofagasta", "Iquique"};
        Graph graph = new Graph(10, cityName);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(8, 9);
        graph.printAdjacentList();

        DepthFirstPaths DFP = new DepthFirstPaths(graph, 0);

        System.out.println("Existe por lo menos 1 camino desde santiago hacia bucalemu? ");
        boolean hasPath = DFP.hasPathTo(6);
        System.out.println(hasPath);
        if (hasPath) {
            System.out.println("¿Cuál es el camino?");
            Stack<Integer> path = DFP.pathTo(6);
            while (!path.isEmpty()) System.out.print(path.pop() + " ");
            System.out.println();
        }

        BreadthFirstPaths BFP = new BreadthFirstPaths(graph, 0);

        System.out.println("Existe por lo menos 1 camino desde santiago hacia bucalemu?" );
        hasPath = BFP.hasPathTo(6);
        System.out.println(hasPath);
        if (hasPath) {
            System.out.println("¿Cuál es el camino más corto?");
            Stack<Integer> path = BFP.pathTo(6);
            while( !path.isEmpty() ) System.out.print(path.pop() + " ");
            System.out.println();
        }

    }
}


