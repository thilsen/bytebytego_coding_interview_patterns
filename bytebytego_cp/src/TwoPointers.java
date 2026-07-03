import java.util.ArrayList;
import java.util.Collections;

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

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(0);
        nums1.add(-1);
        nums1.add(2);
        nums1.add(-3);
        nums1.add(1);
        ArrayList<ArrayList<Integer>> triplets = tp.triplet_sum(nums1);
        System.out.println(triplets);
        System.out.println(tp.is_palindrome_valid("a dog! a panic in a pagoda."));
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
    /*
    Complexity Analysis
        Time complexity: The time complexity of pair_sum_sorted is O(n) because we perform approximately
        n iterations using the two-pointer technique in the worst case.
        Space complexity: We only allocated a constant number of variables, so the space complexity is O(1).
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

    /*
    Triplet Sum
        Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0 . The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicates). If no such triplets are found, return an empty array.

        Each triplet can be arranged in any order, and the output can be returned in any order.

        Example:
        Input: nums = [0, -1, 2, -3, 1]
        Output: [[-3, 1, 2], [-1, 0, 1]]
        Below solution Time complexity is O(nlogn) and Space complexity is O(n)
     */
    public ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(nums);
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if(nums.get(i) > 0) {
                break;
            }
            //Avoid duplicates
            if(i > 0 && nums.get(i) == nums.get(i - 1)) {
                continue;
            }
            int target = -nums.get(i);
            ArrayList<ArrayList<Integer>> pairs = triplet_sum_helper(nums, target, i +  1);
            for(ArrayList<Integer> pair : pairs) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums.get(i));
                triplet.addAll(pair);
                result.add(triplet);
            }
        }
        return result;
    }
    private ArrayList<ArrayList<Integer>> triplet_sum_helper(ArrayList<Integer> nums, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if(sum == target) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums.get(left));
                triplet.add(nums.get(right));
                result.add(triplet);
                left++;
                while(left < right && nums.get(left) == nums.get(left - 1)) {
                    left++;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    /*
    Is Palindrome Valid
        A palindrome is a sequence of characters that reads the same forward and backward.

        Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A character is alphanumeric if it's either a letter or a number.

        Example 1:
        Input: s = 'a dog! a panic in a pagoda.'
        Output: True
        Example 2:
        Input: s = 'abc123'
        Output: False
        Constraints:
        The string may include a combination of lowercase English letters, numbers, spaces, and punctuations.
        Complexity Analysis
            Time complexity: The time complexity of is_palindrome_valid is O(n), where n denotes the length of the string.
            This is because we perform approximately  n iterations using the two-pointer technique.

            Space complexity: We only allocated a constant number of variables, so the space complexity is  O(1).
     */

    public Boolean is_palindrome_valid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
        Shift Zeros to the End
            Given an array of integers, modify the array in place to move all zeros to the end while maintaining the relative order of non-zero elements.

            Example:
            Input: nums = [0, 1, 0, 3, 2]
            Output: [1, 3, 2, 0, 0]
     */
    public static void shiftZerosToTheEnd(ArrayList<Integer> nums) {
        int left = 0;
        for(int right = 0; right < nums.size(); right++) {
            
        }
    }
}
