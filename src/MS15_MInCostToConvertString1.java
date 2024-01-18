import java.util.Arrays;
public class MS15_MInCostToConvertString1 {
    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};
        System.out.println(minimumCost(source, target, original, changed, cost));
    }
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int inf = 1 <<29;
        int[][] g = new int[26][26];
        for(int i=0; i<26; ++i){
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }

        int len = original.length;
        for(int i=0; i<len; ++i){
            int x = original[i]-'a';
            int y = changed[i] - 'a';
            int z = cost[i];
            g[x][y] = Math.min(g[x][y], z);
        }

        for(int k=0; k<26; ++k){
            for(int i=0; i<26; ++i){
                for(int j=0; j<26; ++j){
                    g[i][j]  = Math.min(g[i][j], g[i][k]+g[k][j]);
                }
            }
        }

        long ans = 0;
        for(int i=0; i<source.length(); ++i){
            int x = source.charAt(i)-'a';
            int y = target.charAt(i)-'a';
            if(x != y){
                if(g[x][y] >= inf){
                    return -1;
                }
                ans += g[x][y];
            }
        }
        return ans;
    }
}
