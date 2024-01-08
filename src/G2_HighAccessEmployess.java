import java.util.*;

public class G2_HighAccessEmployess {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a", "0549"));
        list.add(Arrays.asList("b", "0457"));
        list.add(Arrays.asList("a", "0532"));
        list.add(Arrays.asList("a", "0621"));
        list.add(Arrays.asList("b", "0540"));
        List<String> result = findHighAccessEmployees(list);
        System.out.println(result);
    }
    public static List<String> findHighAccessEmployees(List<List<String>> access_times) {
            HashMap<String, List<Integer>> map = new HashMap<>();
            for (var e : access_times) {
                String t = e.get(1);
                int time = Integer.parseInt(t);
                map.computeIfAbsent(e.get(0), k -> new ArrayList<>()).add(time);
            }
            List<String> ans = new ArrayList<>();
            for (var e : map.entrySet()) {
                var tlist = e.getValue();
                Collections.sort(tlist);
                for (int i = 2; i < tlist.size(); i++) {
                    if (tlist.get(i) - tlist.get(i - 2) < 100) {
                        ans.add(e.getKey());
                        break;
                    }
                }
            }
            return ans;
        }
}

