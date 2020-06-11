//Problem Statement: https://leetcode.com/problems/permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> currList, int[] nums) {
        //base condition
        if(currList.size()==nums.length) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        //choices
        for(int i=0;i<nums.length;i++) {
            if(currList.contains(nums[i]))
                continue;
            currList.add(nums[i]);
            helper(result,currList,nums);
            currList.remove(currList.size()-1);
        }
    }
}
