//Problem Statement: https://leetcode.com/problems/jump-game/
class Solution {
    //greedy approach
    public boolean canJump(int[] nums) {
        int maxReachableIndex=0;
        for(int i=0;i<nums.length;i++) {
            //check if current index is greater than maximum reachable index
            if(i>maxReachableIndex)
                return false;
            maxReachableIndex=Math.max(maxReachableIndex, i+nums[i]);
        }
        return true;
    }
}
