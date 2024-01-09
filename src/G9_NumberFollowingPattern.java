import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G9_NumberFollowingPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine(). trim());
        while(t-- > 0){
            System.out.println("Input");
            String S = br.readLine();
            String result = Solution.printMinNumberForPattern(S);
            System.out.println(result);
        }
    }
}
class Solution{
    static String printMinNumberForPattern(String S){
        StringBuilder ans = new StringBuilder();

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=S.length(); i++){
            st.push(i+1);
            if(i == S.length() || S.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    ans.append(st.pop());
                }
            }
        }
        return ans.toString();
    }
}
