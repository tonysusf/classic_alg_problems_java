import java.util.*;

/*
* javac TwoSum.java; java -ea TwoSum
*/


class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        System.out.println("Input is: " + Arrays.toString(nums) + ", target is: " + target);
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] result = {};

        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                result = new int[] {lookup.get(target - nums[i]), i};
                break;
            }
            lookup.put(nums[i], i);
        }

        System.out.println("result is " + Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) {
        System.out.println("starting...");
        // Normal case
        assert Arrays.equals(
            new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9),
            new int[]{0, 1}
        );

        // Answer appears later
        assert Arrays.equals(
            new TwoSum().twoSum(new int[]{3, 2, 4}, 6),
            new int[]{1, 2}
        );

        // Same value used twice, but different indices
        assert Arrays.equals(
            new TwoSum().twoSum(new int[]{3, 3}, 6),
            new int[]{0, 1}
        );

        // Negative numbers
        assert Arrays.equals(
            new TwoSum().twoSum(new int[]{-3, 4, 3, 90}, 0),
            new int[]{0, 2}
        );

        // Zero
        assert Arrays.equals(
            new TwoSum().twoSum(new int[]{0, 4, 3, 0}, 0),
            new int[]{0, 3}
        );
    }
}

