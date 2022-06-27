import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Graph {
    static int colorArray[]=new int[10];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the adjacent matrix size: ");
        int size=in.nextInt();
        int adj[][]=new int[size][size];

        System.out.println("Enter the Matrix");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                adj[i][j]=in.nextInt();
            }
        }
        boolean result=isComplete(size,adj);
        if(result==true) System.out.println("This is a complete graph");
        else System.out.println("This is not a complete graph");
        boolean result1=isDirected(size,adj);
        if(result1==true) System.out.println("This is a Directed graph");
        else System.out.println("This is an undirected  graph");

        System.out.print("Enter the vertex of the graph that u can count the neighbour of the vertex: ");
        int vertex=in.nextInt();
        countNeighbour(vertex,size,adj);
        System.out.println("U and V are connected? Enter the value of u and v: ");
        int u=in.nextInt();
        int v=in.nextInt();
        boolean result2=isConnected(size,u,v,adj);
        if(result2==true) System.out.println("It is connected");
        else System.out.println("It is not connected");
        isBipartite(adj,2);

    }
      //check complete graph
    static boolean isComplete(int size,int adj[][]){
        int flag=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j){
                    if(adj[i][j]==0)flag=1;
                }
                if(adj[i][j]==1&&adj[j][i]==1&&flag==1)return true;

            }

        }
       return false;
    }
    //check directed graph
    static boolean isDirected(int size,int adj[][]){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(adj[i][j]==1&&adj[j][i]==0)return true;
            }
        }
        return false;
    }
    //count neighbour of the vertex
    static void countNeighbour(int u,int size,int adj[][]){
        int count =0;
        for(int i=0;i<size;i++){
            if(adj[u][i]==1)count++;
        }
        System.out.println("The neighbour of the vertex is: "+count);

    }
    //check connected graph
    static boolean isConnected(int size,int u,int v,int adj[][]){
        {
            {
               if(adj[u][v]==1&&adj[v][u]==1)return true;
            }
        }
        return false;
    }

    static void isBipartite(int adj[][],int src){
        int flag = 0;
        colorArray[src]=10;//green
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<adj.length;i++){
            if(adj[src][i]==1 && colorArray[i]==' '){
                colorArray[i]=20;//blue
                q.add(i);
            }

        }
        while(!q.isEmpty()){
            int u=q.remove();
            for(int v=0;v<adj.length;v++){
                if(adj[u][v]==1 && colorArray[u]==colorArray[v]){
                    flag=1;
                }
                if(adj[u][v] == 1 && colorArray[v] == ' ')
                {
                    if(colorArray[u] == 10)
                    {
                        colorArray[u] = 20;
                        q.add(adj[u][v]);
                    }
                    else
                    {
                        colorArray[v] = 10;
                        q.add(adj[u][v]);

                    }

                }

            }
        }

        if(flag==1) System.out.println("NO it is not a bipartite graph");
        else System.out.println("Yes it is a bipartite graph");


    }
}
