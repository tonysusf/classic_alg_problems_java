import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        System.out.println("Input is: " + Arrays.toString(nums) + ", target is: " + target);
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(target - nums[i])) {
                return new int[] {lookup.get(target - nums[i]), i};
            }
            lookup.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 12, 4};
        TwoSum s = new TwoSum();
        int[] result = s.twoSum(nums, 12);
        System.out.println("result is " + Arrays.toString(result));
    }
}


