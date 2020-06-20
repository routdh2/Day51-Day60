//Problem Statement: https://leetcode.com/problems/jump-game-ii/
class Solution {
    public int jump(int[] nums) {
        //corner cases
        if(nums==null || nums.length<=1)
            return 0;
        int maxReachableIndex=0+nums[0];
        int noOfStairs=nums[0];
        int noOfJumps=1;
        for(int i=1;i<nums.length;i++) {
            if(i==nums.length-1)
                return noOfJumps;
            maxReachableIndex=Math.max(maxReachableIndex,i+nums[i]);
            noOfStairs--;
            if(noOfStairs==0) {
                noOfJumps++;
                noOfStairs=maxReachableIndex-i;
            }
        }
        return noOfJumps;
        
    }
}
