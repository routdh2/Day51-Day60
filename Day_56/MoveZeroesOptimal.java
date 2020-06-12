//Problem Statement: https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int start=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                swap(nums,start,i);
                start++;
            }
        }
    }
    
    public void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
