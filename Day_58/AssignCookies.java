//Problem Statement: https://leetcode.com/problems/assign-cookies/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_start=0,c_start=0;
        int count=0;
        while(g_start<g.length && c_start<s.length) {
            if(s[c_start]>=g[g_start]) {
                count++;
                g_start++;
                c_start++;
            }
            else {
                c_start++;
            }
        }
        return count;
    }
}
