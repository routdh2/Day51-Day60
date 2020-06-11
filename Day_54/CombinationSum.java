//Problem Statement: https://leetcode.com/problems/combination-sum
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), candidates, target,0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> currCombination, int[] candidates, int target,int index) {
        
        //base condition
        if(target==0) {
            result.add(new ArrayList<Integer>(currCombination));
            return;
        }
        //choice
        
        for(int i=index;i<candidates.length;i++) {
            int item = candidates[i];
            if(item>target)
                continue;
            currCombination.add(item);
            helper(result,currCombination,candidates,target-item,i);
            currCombination.remove(currCombination.size()-1);
        }
    }
}
