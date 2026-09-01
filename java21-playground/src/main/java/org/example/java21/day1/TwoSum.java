package org.example.java21.day1;

import java.util.HashMap;

public class TwoSum {
    static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ind = twoSum(nums, target);
        System.out.println(ind[0] + " " + ind[1]);
        System.out.println(nums[ind[0]] + " " + nums[ind[1]]);

        int[] indHashMap = twoSumHashMap(nums, target);
        System.out.println(indHashMap[0] + " " + indHashMap[1]);
        System.out.println(nums[indHashMap[0]] + " " + nums[indHashMap[1]]);

        int[] twoSumTwoPointer = twoSumTwoPointer(nums, target);
        System.out.println(twoSumTwoPointer[0] + " " + twoSumTwoPointer[1]);
        System.out.println(nums[twoSumTwoPointer[0]] + " " + nums[twoSumTwoPointer[1]]);


    }


    //Brute Force
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }

    //two pointer if array is sorted
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
