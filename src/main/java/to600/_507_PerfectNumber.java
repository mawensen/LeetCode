package to600;


public class _507_PerfectNumber {


    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int res = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        return res == num;
    }
}