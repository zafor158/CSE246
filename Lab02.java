import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class BFS{

    int[] colour;
    int[] d;
    int[] prev;
    int[] colourGraph;

    Queue<Integer> queue = new LinkedList<>();
    /*
     * White = 10;
     * Grey = 20;
     * Black = 30;
     */

    BFS(int n)
    {
        colour = new int[n];
        d = new int[n];
        prev = new int[n];
        colourGraph = new int[n];
    }

    void BFS_BUILD(int [][] A , int start)
    {

        for(int i= 0; i<A.length;i++)
        {


            colour[i] = 10;
            d[i] = 0;
            prev[i] = -1;
            colourGraph[i] = 0;
        }
        colour[start] = 20;
        d[start] = 0;
        prev[start] = 0;


        queue.add(start);


        while(!queue.isEmpty())
        {

            int u = queue.remove();
            System.out.print(u+" ");


            for(int i = 0; i<A.length;i++)
            {
                if(A[u][i] == 1 && colour[i] == 10)
                {

                    colour[i] = 20;
                    d[i] = d[u]+1;
                    prev[i] = u;
                    queue.add(i);

                }
            }
            colour[u] = 30;


        }

    }

    void shortPath(int [][] A, int source, int des)
    {
        if(source == des)
        {
            System.out.print(source+" ");
        }
        else if(prev[des] == -1)
        {
            System.out.println("No path");
        }
        else {
            try{
                shortPath(A, source, prev[des]);
                System.out.print(des+" ");

            }catch (Exception e)
            {
                System.out.println(e);
            }


        }


    }

    void isBipartite(int [][] A, int source,int size)
    {
        int flag = 1;
        Queue<Integer> queue2 = new LinkedList<>();
        /*
         * GREEN = 4
         * BLUE = 5

         */

      colourGraph[source] = 4;


      for(int i = 0; i<size; i++)
      {
          if(A[source][i] == 1 && colourGraph[i] == 0)
          {
              colourGraph[i] = 5;
              queue2.add(i);

          }

      }
      while(!queue2.isEmpty())
      {
          int  v = queue2.remove();

          for(int i = 0; i<size;i++)
          {
              if(A[v][i] == 1 && colourGraph[v] == colourGraph[i])
              {
                  flag = 0;
              }
              if(A[v][i] == 1 && colourGraph[i] == 0)
              {
                  if(colourGraph[v] == 4)
                  {
                      colourGraph[i] = 5;
                      queue2.add(A[v][i]);
                  }
                  else
                  {
                      colourGraph[i] = 4;
                      queue2.add(A[v][i]);

                  }

              }
          }
      }
      if(flag == 0)
      {
          System.out.println("NOT BIPARTITE");
      }
      else
          System.out.println("BIPARTITE");


    }



}









public class Lab02 {
    public static void main(String[] arg)
    {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("Enter the number of your Vertex->");

        size = scan.nextInt();


        if(size == 0 || size == 1)
        {
            System.out.println("ENTER VALID NUMBER OF VERTEX WHICH IS GREATER THAN TWO.");
            return;
        }

        BFS b1 = new BFS(size);



        int[][] A = new int[size][size];

        for(int i = 0; i<size; i++)
        {
            System.out.println("Enter the values of "+(i+1)+" Row");
            for(int j = 0; j<size; j++)
            {
                A[i][j] = scan.nextInt();
            }
        }


        int start,source,des;

        System.out.println("Please, Enter the Vertex which your want to start your Journey!");
        start = scan.nextInt();

        System.out.println("Start our Journey from "+start+" So");
        System.out.println("The Graph:");
        b1.BFS_BUILD(A, start);

        System.out.println("\nEnter the source you want to start");
        source = scan.nextInt();

        System.out.println("Enter the destination of you want to going");

        des = scan.nextInt();

        System.out.print("\nPrint Shortest path: ");
        b1.shortPath(A, source, des);

        System.out.println("\nCheck whether the graph is bipartite or not?");

        System.out.println("\nEnter the source you want to start");
        int  source1 = scan.nextInt();
        b1.isBipartite(A,source1,size);


    }
}
