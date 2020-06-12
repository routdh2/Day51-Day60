//Problem Statement: https://leetcode.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {
        //to use linear time and constant space
        //step-1 replace all negative nos and nos greater than n
        int n=nums.length;
        boolean isOnePresent=false;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) {
                isOnePresent=true;
            }
            else if(nums[i]<=0 || nums[i]>n) {
                nums[i]=1;
            }
        }
        if(!isOnePresent)
            return 1;
        //step-2 mark the nos as negative if we have seen them
        for(int i=0;i<n;i++) {
            int index=Math.abs(nums[i])-1;//to make 0 based index
            if(nums[index]>0) {
                nums[index]=-1*nums[index];
            }
        }
        
        //step-3 look for first positive no
        for(int i=0;i<n;i++) {
            if(nums[i]>0) {
                return i+1;
            }
        }
        return n+1;//corner case [1,2,3]->4
        
    }
}
