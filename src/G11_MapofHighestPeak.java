import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;


public class G11_MapofHighestPeak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine(). trim());
        while(t-- > 0){
            System.out.println("Input");
            int row = Integer.parseInt(br.readLine().trim());
            int col = Integer.parseInt(br.readLine().trim());
            System.out.println("Input");

            int[][] a = new int[row][col];
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++) {
                    a[i][j] = Integer.parseInt((br.readLine().trim()));
                }
            }

            int[][] ans = new Solution_10().highestPeak(a);
            for(int i=0; i<row; i++)
                for(int j=0; j<col; j++) {
                   System.out.print(ans[i][j] + " ");
                }
            System.out.println();
            }
        }
}

class Solution_10 {
    public int[][] highestPeak(int[][] isWater) {
        int[] d= {0, 1, 0, -1, 0};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j] == 1){
                    height[i][j] = 0;
                    q.offer(new int[]{i,j});

                }else{
                    height[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row= cell[0];
            int col = cell[1];
            for(int k=0; k<4; k++){
                int x = row + d[k];
                int y = col + d[k+1];
                if(x>=0 && x<m && y>=0 && y<n && height[x][y] < 0){
                    height[x][y] = height[row][col]+1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return height;
    }
}
