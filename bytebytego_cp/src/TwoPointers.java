import java.util.ArrayList;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers tp = new TwoPointers();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(6);
        int target = 6;
        ArrayList<Integer> ans = tp.pair_sum_sorted(nums, target);
        System.out.println(ans);
    }

    /*
    Pair Sum - Sorted
        Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

        Example 1:
        Input: nums = [-5, -2, 3, 4, 6], target = 7
        Output: [2, 3]
        Explanation: nums[2] + nums[3] = 3 + 4 = 7

        Example 2:
        Input: nums = [1, 1, 1], target = 2
        Output: [0, 1]
        Explanation: other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2] or [2, 1].
     */
    public ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                ans.add(left);
                ans.add(right);
                break;
            }
        }
        return ans;
    }
}
