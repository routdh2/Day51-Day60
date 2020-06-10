//Problem Statement: https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int start=0,end=nums.length-1;
        for(int i=0;i<nums.length;) {
            if(nums[i]==0 && i>start) {
                swap(nums,start,i);
                start++;
            }
            else if(nums[i]==2 && i<end) {
                swap(nums,end,i);
                end--;
            }
            else {
                i++;
            }
        }
    }
    public void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
