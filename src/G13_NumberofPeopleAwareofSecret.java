import  java.util.ArrayList;
public class G13_NumberofPeopleAwareofSecret {
    public static void main(String[] args) {
        int n = 6, delay=2, forget=4;
        int ans = peopleAwareOfSecret(n, delay, forget);
        System.out.println(ans);
    }
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = (long) 1e9 + 7;
        ArrayList<Long> list = new ArrayList<>(forget);
        for (int i = 0; i < forget; i++) {
            list.add((long) 0);
        }
        list.add((long) 1);
        int day = 1;
        long x = 0;
        while (day < n) {
            x = x - list.get(list.size() - forget) % mod;
            x = x + list.get(list.size() - delay) % mod;
            list.add(x);
            day++;
        }
        long ans = 0;
        for (int i = list.size() - 1; i >= list.size() - forget; i--) {
            ans = (ans + list.get(i)) % mod;
        }
        return (int) ans;
    }
}
