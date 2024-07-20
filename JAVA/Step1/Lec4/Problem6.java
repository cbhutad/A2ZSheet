import java.util.Scanner;

public class Problem6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println(sumOfDivisors(n));
    }

    static long sumOfDivisors(int N) {

        //final sum
        long sum = 0;

        for(int i = 1;i <= N;i++) {
            if(N % i == 0) {
                sum += (N);
            } else {
                sum += (N/i) * i;
            }
        }
        return sum;
    }
}
