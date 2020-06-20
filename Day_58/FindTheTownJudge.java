//Problem Statement: https://leetcode.com/problems/find-the-town-judge/
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] arr = new int[N+1][2];
        for(int i=0;i<trust.length;i++) {
            int trustingIndex=trust[i][0];
            int trustedByIndex=trust[i][1];
            arr[trustingIndex][0]++;
            arr[trustedByIndex][1]++;
        }
        for(int i=1;i<arr.length;i++) {
            if(arr[i][0]==0 && arr[i][1]==N-1)
                return i;
        }
        return -1;
        
    }
}
