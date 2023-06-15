import java.util.*;
import java.util.Queue;

public class GraphS {
    private ArrayList<ArrayList<Integer>> adj;
    private final int V;
    private int E;
    private String cityNames[];


    public GraphS(int V, String[] cityNames) {
        this.V = V;
        this.E = 0;
        this.cityNames = cityNames;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
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

        public DepthFirstPaths(GraphS G, int s) {
            marked = new boolean[G.V];
            edgeTo = new int[G.V];
            this.s = s;
            dfs(G, s);
        }

        private void dfs(GraphS G, int v) {
            marked[v] = true;
            for (int w : G.adj.get(v))
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x = v; x != s; x = edgeTo[x])
                path.push(x);
            path.push(s);
            return path;
        }
    }

    public static class BreadthFirstPaths
    {
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;
        public BreadthFirstPaths(GraphS G, int s)
        {
            marked = new boolean[G.V];
            edgeTo = new int[G.V];
            this.s = s;
            bfs(G, s);
        }
        private void bfs(GraphS G, int s)
        {
            Queue<Integer> queue = new LinkedList<>();
            marked[s] = true; // Mark the source
            queue.offer(s); // and put it on the queue.
            while (!queue.isEmpty())
            {
                int v = queue.poll(); // Remove next vertex from the queue.
                for (int w : G.adj.get(v))
                    if (!marked[w]) // For every unmarked adjacent vertex,
                    {
                        edgeTo[w] = v; // save last edge on a shortest path,
                        marked[w] = true; // mark it because path is known,
                        queue.offer(w); // and add it to the queue.
                    }
            }
        }
        public boolean hasPathTo(int v)
        { return marked[v]; }

        public Stack<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x = v; x != s; x = edgeTo[x])
                path.push(x);
            path.push(s);
            return path;
        }
    }


    public static void main(String[] args) {
        String[] cityName = {"Santiago", "Valparaiso", "Vina del mar", "Rancagua", "Melipilla", "Pichilemu", "Bucalemu", "Talca", "Antofagasta", "Iquique"};
        GraphS graphS = new GraphS(10, cityName);
        graphS.addEdge(0, 1);
        graphS.addEdge(0, 3);
        graphS.addEdge(1, 2);
        graphS.addEdge(3, 4);
        graphS.addEdge(3, 5);
        graphS.addEdge(3, 7);
        graphS.addEdge(4, 5);
        graphS.addEdge(5, 6);
        graphS.addEdge(8, 9);
        graphS.printAdjacentList();

        DepthFirstPaths DFP = new DepthFirstPaths(graphS, 0);

        System.out.println("Existe por lo menos 1 camino desde santiago hacia bucalemu? ");
        boolean hasPath = DFP.hasPathTo(6);
        System.out.println(hasPath);
        if (hasPath) {
            System.out.println("¿Cúal es el camino?");
            Stack<Integer> path = DFP.pathTo(6);
            while (!path.isEmpty()) System.out.print(path.pop() + " ");
            System.out.println();
        }

        BreadthFirstPaths BFP = new BreadthFirstPaths(graphS, 0);

        System.out.println("Existe por lo menos 1 camino desde santiago hacia bucalemu?" );
        hasPath = BFP.hasPathTo(6);
        System.out.println(hasPath);
        if (hasPath) {
            System.out.println("¿Cúal es el camino más corto?");
            Stack<Integer> path = BFP.pathTo(6);
            while( !path.isEmpty() ) System.out.print(path.pop() + " ");
            System.out.println();
        }

    }
}


