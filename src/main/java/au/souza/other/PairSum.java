package au.souza.other;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class PairSum {

    public static List<Pair> findPairsWithSum(int[] nums, int targetSum) {
        HashSet<Integer> seen = new HashSet<>();
        List<Pair> pairs = new ArrayList<>();

        for (int num : nums) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                pairs.add(new Pair(complement, num));
            }
            seen.add(num);
        }

        return pairs;
    }

    public static void main(String[] args) {
        // int[] nums = {2, 7, 11, 15, 1, 8, 3};
        // int target = 9;
        int[] nums = {1, 3, 7, 9, 2};
        int target = 11;
        List<Pair> result = findPairsWithSum(nums, target);
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }
}

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
