
//Problem Statement: https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> currCombination, int[] nums, boolean[] used) {
        //base case
        if(currCombination.size()==nums.length) {
            result.add(new ArrayList<Integer>(currCombination));
            return;
        }
        
        //choice
        for(int i=0;i<nums.length;i++) {
            //skip duplicates
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            currCombination.add(nums[i]);
            used[i]=true;
            helper(result,currCombination, nums,used);
            currCombination.remove(currCombination.size()-1);
            used[i]=false;
        }
    }
}
