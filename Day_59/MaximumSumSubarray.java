//Problem Statement: https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int temp_max=0;
        for(int i=0;i<nums.length;i++) {
            temp_max+=nums[i];
            maxSum=Math.max(maxSum,temp_max);
            temp_max=temp_max<0?0:temp_max;
        }
        return maxSum;
    }
}
