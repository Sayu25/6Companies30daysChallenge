import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G7_FindRepeatingMissigNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine(). trim());
        while(t-- > 0){
            System.out.println("Input");
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println("Input");
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " "+ ans[1]);
        }
    }
}
class Solve{
    int[] findTwoElement(int arr[], int n){
        int[] ans = new int[2];
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            temp[arr[i] - 1] ++;
            if(temp[arr[i] -1] > 1){
                ans[0] = arr[i];
            }
        }
        for(int i=0; i<n; i++){
            if(temp[i] == 0){
                ans[1] = i+1;
                break;
            }
        }
        return ans;
    }
}
