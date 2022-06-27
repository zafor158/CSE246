import java.util.Scanner;
import java.util.Stack;

public class Lab03Test {
    static int color[], prev[],d[], f[];
    static int n;
    static int adj[][];
    static int time;
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> st1 = new Stack<>();

    public static void main(String args[]){
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

        for(int u=0;u<n;u++){

            if(color[u]==0) dfsVisit(u);
        }

        // print dfs
        System.out.println("The visited nodes according to DFS:");

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println();
    }

    static void dfsVisit(int u){
        color[u] = 1;  // 1 == gray
        time = time+1;
        d[u] = time;

        for(int v=0;v<n;v++){

            if(adj[u][v]==1 && color[v]==0){
                prev[v] = u;
                dfsVisit(v);
            }
        }
        color[u] = 2;   // 2 == black
        time = time+1;
        f[u] = time;

        st.push(u);


    }
    //using stack
    static void visitDFS(int u){
        st1.push(u);
        while(!st1.isEmpty()){
            int x=st1.pop();
            if(color[x]==0) {
                time = time + 1;
                d[x] = time;
                color[x] = 1;
                st1.push(x);

            for(int v=0;v<n;v++){
                if(adj[x][v]==1&&color[v]==0){
                    prev[v]=x;
                    st1.push(v);
                }
            }
        }
        else if(color[x]==1){
            time=time+1;
            f[x]=time;
            color[x]=2;
            }
        }
    }




}

// The graph is provided below
/*
node=5
0 1 0 0 1
1 0 1 1 1
0 1 0 1 0
0 1 1 0 1
1 1 0 1 0
*/

