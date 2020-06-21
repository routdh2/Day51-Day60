//Problem Statement: https://leetcode.com/problems/maximum-sum-circular-subarray
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxSumSubarray=Integer.MIN_VALUE;
        int tempMaxSum=0;
        int minSumSubarray=Integer.MAX_VALUE;
        int tempMinSum=0;
        int totalSum=0;
        for(int i=0;i<A.length;i++) {
            //add current value to temp
            tempMaxSum+=A[i];
            maxSumSubarray=Math.max(maxSumSubarray,tempMaxSum);
            tempMaxSum=tempMaxSum<0?0:tempMaxSum;
            //add to total Sum
            totalSum+=A[i];
            //find Min sum subarray
            tempMinSum+=A[i];
            minSumSubarray=Math.min(minSumSubarray,tempMinSum);
            tempMinSum=tempMinSum>0?0:tempMinSum;
        }
        //case-1 if all the nos are negative
        if(totalSum==minSumSubarray) {
            return maxSumSubarray;
        }
        else {
            //it has mix of positive and negative nos
            return Math.max(totalSum-minSumSubarray,maxSumSubarray);
        }
    }
}
