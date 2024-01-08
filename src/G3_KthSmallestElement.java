import java.util.*;
import java.util.List;
import  java.util.ArrayList;
import javafx.util.Pair;
public class G3_KthSmallestElement {
    public static void main(String[] args){
        String[] nums = {"102", "473","251","814"};
        int[][] queries = {
                {1,1}, {2, 3}, {4,2}, {1,2}
        };
        int[] result = smallestTrimmedNumbers(nums, queries);
        System.out.print(Arrays.toString(result));
    }
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int m = queries.length;
        int n = nums.length;
        int len = nums[0].length();
        int[] ans = new int[m];

        for(int i=0; i<m; i++){
            int trim = queries[i][1];
            int kSmallest = queries[i][0];
            List<Pair<String, Integer>> list = getStringsInSortedOrder(nums, trim);
            ans[i] = list.get(kSmallest-1).getValue();
        }
        return ans;
    }
    private static List<Pair<String, Integer>> getStringsInSortedOrder(String[] nums, int len){
        int n = nums.length;
        int initlen = nums[0].length();
        List<Pair<String, Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringBuilder x = new StringBuilder(nums[i].substring(initlen-len));
            while(x.length()>0){
                if(x.charAt(0) == '0'){
                    x.deleteCharAt(0);
                }else{
                    break;
                }
            }
            list.add(new Pair(x.toString(), i));
        }
        Collections.sort(list, (a, b)-> {
            StringBuilder x = new StringBuilder(a.getKey());
            StringBuilder y = new StringBuilder(b.getKey());
            if(x.length() != y.length()){
                return x.length() - y.length();
            }
            if(x.toString().equals(y.toString())){
                return a.getValue() - b.getValue();
            }return x.toString().compareTo(y.toString());
        });
        return list;
    }
}
