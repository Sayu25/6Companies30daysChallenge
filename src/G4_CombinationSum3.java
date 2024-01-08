import java.util.ArrayList;

import java.util.ArrayList;
import java.util.*;

public class G4_CombinationSum3 {
    public static void main(String[] args){
        int k =3;
        int n =9;
        List<List<Integer>>  result = new ArrayList<>();
        result = combinationSum3(k, n);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans2= new ArrayList<>();
        helper(1, 0, n, ans, ans2, k);
        return ans;
    }
    private static void helper(int ind, int sum, int n, List<List<Integer>> ans, List<Integer> ans2, int k){
        if(sum == n && k==0){
            ans.add(new ArrayList<>(ans2));
        }
        if(sum >n){
            return;
        }
        for(int i=ind; i<=9; i++){
            if(i>n){
                break;
            }
            ans2.add(i);
            helper(i+1, sum+i, n, ans, ans2, k-1);
            ans2.remove(ans2.size()-1);
        }
    }
}
