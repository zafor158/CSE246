import java.util.Arrays;
import java.util.Scanner;
public class Majority_element {
    static int max=0,mf=-1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size=in.nextInt();

        int a[]=new int[size];
        for(int i=0;i<size;i++){
            a[i]=in.nextInt();
        }
        majority_Element(a,size);
    }
    static void majority_Element(int a[], int size)
    {
        int max_count = 0;
        System.out.println("Most occurred number");
        for (int i=0; i<size; i++)
        {
            int count=1;
            for (int j=i+1;j<size;j++){
                if (a[i]==a[j])
                    count++;
            }
            if (count>max_count)
                max_count = count;

        }
        //System.out.print(mf);

        for (int i=0;i<size;i++)
        {
            int count=1;
            for (int j=i+1;j<size;j++){
                if (a[i]==a[j])
                    count++;

            }
            if (count==max_count){
                System.out.println(a[i]);
            }
            }
    }
}
