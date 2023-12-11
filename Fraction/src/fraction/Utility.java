package fraction;

public class Utility {
    public static long greatestCommonDivisor(long a, long b){
        a = Math.abs(a);
        b = Math.abs(b);
        long c;
        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
