import java.util.*;

class G5_RandomFlipMatrix {
    private static int m;
    private static int n;

    public static void main(String[] args) {
        G5_RandomFlipMatrix obj = new G5_RandomFlipMatrix(m, n);
        int[] param_1 = obj.flip();
        obj.reset();
    }
    private int total;
    private Random rand = new Random();
    private Map<Integer, Integer> map = new HashMap<>();
    public G5_RandomFlipMatrix(int m, int n){
            this.m = m;
            this.n = n;
            this.total = m * n;
    }

        public int[] flip () {
            int x = rand.nextInt(total--);
            int idx = map.getOrDefault(x, x);
            map.put(x, map.getOrDefault(total, total));
            return new int[]{idx / n, idx % n};
        }

        public void reset () {
            total = m * n;
            map.clear();
        }

}


