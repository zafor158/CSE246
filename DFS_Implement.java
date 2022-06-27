import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class DFS {
    int color[], prev[], d[], f[], time;
    Stack<Integer> q = new Stack<>();
    int n;  // number of nodes/ vertices
    int adj[][];   // adjacency matrix or graph

    public DFS(int n) {
        this.n = n;
        color = new int[n];
        prev = new int[n];
        d = new int[n];
        f=new int[n];
        adj = new int[n][n];// declared

    }
    void initialize() {
        for (int u = 0; u< n; u++) {
            color[u] = 0;    // white = 0, gray = 1, black = 2
            prev[u] = -1;
            d[u] = 9999;
            f[u]=9999;
        }
        time=0;
        for(int u=0;u<n;u++){
            if(color[u]==0)
                DFS_Visit(u);
        }
        //print dfs
        System.out.println("The visiting nodes according to dfs");
        while(!q.isEmpty()){
            System.out.print(q.pop()+" ");
        }
    }
void DFS_Visit(int u){
        color[u]=1;
        time=time+1;
        d[u]=time;
        for(int v=0;v<n;v++){
            if(adj[u][v]==1){
                if(color[v]==0)
                    prev[v]=u;
                DFS_Visit(v);
            }
        }
        color[u]=2;
        time=time+1;
        f[u]=time;
        q.push(u);
        }
}

public class DFS_Implement {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the number of node: ");
        int n=in.nextInt();
        System.out.println("Enter the  of adjacency matrix ");

        int adj[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j]=in.nextInt();
            }
        }
       DFS dfs=new DFS(n);
        dfs.initialize();
    }
}

