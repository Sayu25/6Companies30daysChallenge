public class G14_RunLengthEncoding {
    public static void main(String[] args) {
        String str = "aaaabbc";
        String ans = encode(str);
        System.out.println(ans);
    }
    public  static String encode(String str)

    {
        StringBuilder sb = new StringBuilder("");
        int n = str.length();
        for(int i=0; i<n ; i++){
            int count=1;
            while(i < n-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i)+""+count);

        }
        return sb.toString();
    }
}
