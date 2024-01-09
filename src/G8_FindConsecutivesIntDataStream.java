public class G8_FindConsecutivesIntDataStream {
    int count=0;
    int val, n;
    public G8_FindConsecutivesIntDataStream(int value, int k) {
        val = value;
        n = k;
        count=0;

    }
    public boolean consec(int num) {
        if(num == val){
            count++;
        }else{
            count=0;
            return false;
        }
        if(count== n){
            count= n-1;
            return true;
        }
        return false;
    }
}
