//Problem Statement: https://leetcode.com/problems/broken-calculator/
class Solution {
    //runs in O(logY) time and O(1) space
    public int brokenCalc(int X, int Y) {
        int steps=0;
        while(Y>X) {
            steps++;
            if(Y%2==0)
                Y=Y/2;
            else
                Y++;
        }
        return steps+X-Y;     
    }
}
