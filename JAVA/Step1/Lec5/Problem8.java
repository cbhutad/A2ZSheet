import java.util.Scanner;

public class Problem8 {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(isPalindrome(input));
    
    }

    private static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer("");

        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) - 'A' >= 0 && 'Z' - s.charAt(i) >= 0) {
                sb.append((char)((s.charAt(i) - 'A') + 'a'));
            } else if(s.charAt(i) - 'a' >= 0 && 'z' - s.charAt(i) >= 0) {
                sb.append(s.charAt(i));
            } else if(s.charAt(i) - '0' >= 0 && '9' - s.charAt(i) >= 0) {
                sb.append(s.charAt(i));
            }
        }

        String temp = sb.toString();
        String reverseTemp = sb.reverse().toString();

        return temp.equals(reverseTemp);
    }
}
