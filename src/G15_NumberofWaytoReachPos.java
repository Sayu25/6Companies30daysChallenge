public class G15_NumberofWaytoReachPos {
    private static Integer[][] f;
    private static final int mod = (int) 1e9 + 7;
    public static int numberOfWays(int startPos, int endPos, int k) {
        f = new Integer[k + 1][k + 1];
        return dfs(Math.abs(startPos - endPos), k);
    }

    private static int dfs(int i, int j) {
        if (i > j || j < 0) {
            return 0;
        }
        if (j == 0) {
            return i == 0 ? 1 : 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j - 1) + dfs(Math.abs(i - 1), j - 1);
        ans %= mod;
        return f[i][j] = ans;
    }
    public static void main(String[] args) {
        int startPos=1;
        int endPos=2 ;
        int k=3;
        int ans = numberOfWays(startPos, endPos, k);
        System.out.println(ans);
    }
}
