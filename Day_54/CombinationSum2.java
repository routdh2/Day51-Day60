//Problem Statement: https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> currCombination, int[] candidates, int target, int index) {
        //base case
        if(target==0) {
            result.add(new ArrayList<Integer>(currCombination));
            return;
        }
        
        if(target<0)
            return;
        
        //choices
        
        for(int i=index;i<candidates.length;i++) {
            int item=candidates[i];
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            currCombination.add(item);
            helper(result,currCombination, candidates, target-item, i+1);
            currCombination.remove(currCombination.size()-1);
        }
    }
}
