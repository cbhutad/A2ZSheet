package JAVA.Step1.Lec6;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] nums = new int[n];

        for(int i =0 ;i < n;i++) {
            nums[i] = sc.nextInt();
        }

        frequencyCount(nums, n, p);
    }

    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        
        int[] nums = new int[P];
        
        for(int i = 0;i < N;i++) {
            if(arr[i] <= N)
                nums[arr[i]-1] += 1;
            arr[i] = 0;
        }
        
        for(int i = 0;i < P;i++) {
            if(i < N)
                arr[i] = nums[i];
        }
    }

}