//Problem Statement: https://leetcode.com/problems/majority-element/
class Solution {
    //runs in O(n) time and O(1) space
    public int majorityElement(int[] nums) {
        if(nums==null ||nums.length==0)
            return 0;
        //we will use moore voting algo
        //step-1 find the candidate for the majority element
        int candidate = findCandidate(nums);
        //step -2 verify if it's actually the majority element
        if(isMajority(candidate,nums))
            return candidate;
        else
            return 0;
    }
    public int findCandidate(int[] nums) {
        int candidate=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++) {
            if(candidate==nums[i]) {
                count++;
            }
            else {
                count--;
                if(count==0) {
                    candidate=nums[i];
                    count=1;
                }
            }
        }
        return candidate;
    }
    public boolean isMajority(int candidate,int[] nums) {
        int count=0;
        for(int i:nums) {
            if(candidate==i)
                count++;
        }
        return count>(nums.length/2);
    }
    
}
