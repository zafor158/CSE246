import java.util.Scanner;
import java.util.Stack;
public class edge {
    static int color[], prev[],d[], f[];
    static int n;
    static int adj[][];
    static int time;
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> st1 = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Node");
        n = sc.nextInt();
        color = new int[n];
        prev = new int[n];
        d = new int[n];
        f = new int[n];
        adj = new int[n][n];

        System.out.println("Enter adjacency matrix");

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j] = sc.nextInt();
            }
        }
        // Initialization
        for(int u = 0;u<n;u++){
            prev[u] = -1;
            color[u] = 0;
            f[u] = 999;
            d[u] = 999;
        }
        time = 0;
        DFS_Visit(0);

    }
    static void DFS_Visit(int u){
        color[u]=1;
        time=time+1;
        d[u]=time;

        for(int v=0;v<adj.length;v++){
            if(adj[u][v]==1){
                if(color[v]==2){
                    if(d[u]<d[v]){
                        System.out.println("("+u+","+v+")"+"---"+"forward edge");
                    }else{
                        System.out.println("("+u+","+v+")"+"---"+"cross edge");
                    }
                }
                if(color[v]==1){
                    System.out.println("("+u+","+v+")"+"---"+"back edge");
                }
                if(color[v]==0){
                    System.out.println("("+u+","+v+")"+"---"+"tree edge");
                    DFS_Visit(v);
                }
            }

        }
        color[u]=2;
        time=time+1;
        f[u]=time;
    }
}
