//Problem Statement: https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(),nums,0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> currCombination, int[] nums,int index) {
        //base case
        result.add(new ArrayList<Integer>(currCombination));
        //choice
        for(int i=index;i<nums.length;i++) {
            currCombination.add(nums[i]);
            helper(result,currCombination, nums,i+1);
            currCombination.remove(currCombination.size()-1);
        }
    }
}
