import java.util.*;
public class G5_LetterCombinationsofPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans = phone("", digits);
        return ans;

    }
    public static List<String> phone(String p, String up){

        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit= up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();
        int i=(digit-2)*3;
        if(digit > 7){
            i+=1;
        }
        int len = i+3;
        if(digit ==7 || digit == 9){
            len +=1;
        }
        for(; i<len; i++){
            char ch = (char)('a'+i);
            list.addAll(phone(p+ch, up.substring(1)));
        }
        return list;
    }
}
