//Problem Statement: https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(),nums,0, new boolean[nums.length]);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> currCombination, int[] nums,int index, boolean[] used) {
        //base case
        result.add(new ArrayList<Integer>(currCombination));
        //choice
        for(int i=index;i<nums.length;i++) {
            //skip duplicates
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            currCombination.add(nums[i]);
            used[i]=true;
            helper(result,currCombination,nums,i+1,used);
            currCombination.remove(currCombination.size()-1);
            used[i]=false;
        }
    }
}
