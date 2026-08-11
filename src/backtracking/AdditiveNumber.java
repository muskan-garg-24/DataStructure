package backtracking;

import java.util.*;

public class AdditiveNumber {

    public static boolean backtrack(String num, int index, List<Long> sequence) {

        if (index == num.length()) {
            return sequence.size() >= 3;
        }

        long current = 0;

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0') {
                break;
            }

            current = current * 10 + (num.charAt(i) - '0');

            if (sequence.size() >= 2) {

                long sum = sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2);

                if (current < sum) {
                    continue;
                }

                if (current > sum) {
                    break;
                }
            }

            sequence.add(current);

            if (backtrack(num, i + 1, sequence)) {
                return true;
            }

            sequence.remove(sequence.size() - 1);
        }

        return false;
    }

    public static boolean isAdditiveNumber(String num) {

        return backtrack(num, 0, new ArrayList<>());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String num = sc.next();

        System.out.println(isAdditiveNumber(num));
        sc.close();
    }
}
