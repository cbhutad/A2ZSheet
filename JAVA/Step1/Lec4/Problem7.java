import java.util.Scanner;

public class Problem7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i < n;i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(minJumps(arr,n));
    }

    private static int minJumps(int[] arr, int n) {
        // your code here
        
        if (n != 1 && arr[0] == 0)
            return -1;
        // Frog is already on the last stone.
        else if (n == 1)
            return 0;
        
        // count of jumps required.
        int count = 1;
        // position of previous stone from which frog jumped.
        int prevIndex = 0;
        // position of next stone to which the frog jumps.
        int currentIndex = arr[prevIndex] + prevIndex;
        // to check the max distance the frog can jump from a given stone.
        int max;
        
        // This is as follows, if stone has value 0 then frog can jump from that stone. So if we can shift our jump to stone mentioned in previous sentence minus one position. This is what currentIndex indicates, but if currentIndex becomes equal to previousIndex it shows that from previousIndex stone whose value is say x, even if jump to value y <= x all the stones which can be reached using the ranges of values of y are value of 0. So this is first condition to be checked and to stop as we reach the end stone we check if currentIndex is less than the index for last stone.
        for(; currentIndex > prevIndex && currentIndex < n-1;) {
            max = -1;
            int i, temp = currentIndex;
            // Logic to determine which is the next stone the frog should jump to minimum number of jumps.
            for(i = currentIndex; i > prevIndex ;i--) {
                // In order to do so,  we check which stone has the  value of the stone from the index of the stone as largest as shown in arr[i] + i and then we set it to max, since we also need the index of stone seperately we store it in temp. if any stone here has zero value we skip it as jumping to that stone has no value and this must be checked first.
                if (arr[i] != 0 && max < (arr[i] + i)) {
                    max = arr[i] + i;
                    temp = i;
                }
            }
            // If we have a max this will indicate we have a new value to jump from. So we update the previousIndex as new index of stone to jump to and currentIndex as index of stone plus the value of stone. This will give the longest jump we could do from the updated previousIndex stone.
            if(max != 0) {
                //System.out.println(max + " " + temp + " " + currentIndex + " " + prevIndex);
                prevIndex = temp;
                currentIndex = prevIndex + arr[prevIndex];
                //System.out.println(max + " " + temp + " " + currentIndex + " " + prevIndex);
                count++;
            } 
            // Otherwise we reach the point where currentIndex becomes same as previousIndex. 
            else {
                currentIndex = prevIndex;
                break;
            }
        }
        // The condition where there is no stone in range the frog can jump to.
        if(currentIndex == prevIndex)
            return -1;
        // Else we just return count.
        return count;
        
    }
}
}
