import java.util.Set;
import java.util.HashSet;
public class G10_KDivisbleSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2 ,2};
        int k=2, p=2;
        Set<String> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            int count=0;
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<nums.length; j++){
                if(nums[j] % p == 0){
                    count++;
                }
                if(count> k){
                    break;
                }
                sb.append(nums[j]+" ");
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
