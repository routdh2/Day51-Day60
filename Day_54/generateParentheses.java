//Problem Statement: https://leetcode.com/problems/generate-parentheses/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }
    
    private void backtrack(List<String> result, String currCombination, int left, int right) {
        //base condition
        if(left==0 && right==0) {
            result.add(currCombination);
            return;
        }
        //our choices
        if(left<0 || left>right)
            return;
        backtrack(result,currCombination+"(",left-1,right);
        backtrack(result,currCombination+")",left,right-1);
    }
}
