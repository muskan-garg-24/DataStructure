package recursion;

import java.util.Scanner;

public class KthCharacterInTheStringGameI {

    public static char kthCharacter(int k) {

        return helper(k);
    }

    public static char helper(int k) {

        if (k == 1) {
            return 'a';
        }

        int len = 1;

        while (len < k) {
            len *= 2;
        }

        int half = len / 2;

        if (k <= half) {
            return helper(k);
        }

        char ch = helper(k - half);

        return (char) (ch + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        System.out.println(kthCharacter(k));

        sc.close();
    }
}