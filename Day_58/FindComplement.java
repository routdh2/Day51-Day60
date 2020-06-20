//Problem Statement: https://leetcode.com/problems/number-complement/
class Solution {
    public int findComplement(int num) {
        int result=0;
        int i=0;//starts from LSB(least significant bit)
        while(num>0) {
            if((num&1)==0) {//if the corresponding bit is not set
                result+=(1<<i);//1<<i -> denotes the decimal representation of no after complementing
            }
            i++;
            num=num>>1;//we decrease by one bit
        }
        return result;
        
    }
}
