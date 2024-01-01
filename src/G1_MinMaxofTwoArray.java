public class G1_MinMaxofTwoArray {
    public static void main(String[] args) {
        int divisor1= 2;
        int divisor2= 4;
        int uniqueCnt1= 8;
        int uniqueCnt2= 2;
        int ans = minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2);
        System.out.println(ans);
    }
    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            long divisor = lcm(divisor1, divisor2);
            long left = 1, right = 10000000000L;
            while (left < right) {
                long mid = (left + right) >> 1;
                long cnt1 = mid / divisor1 * (divisor1 - 1) + mid % divisor1;
                long cnt2 = mid / divisor2 * (divisor2 - 1) + mid % divisor2;
                long cnt = mid / divisor * (divisor - 1) + mid % divisor;
                if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cnt >= uniqueCnt1 + uniqueCnt2) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return (int) left;
        }

        private static long lcm(int a, int b) {
            return (long) a * b / gcd(a, b);
        }

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
}
