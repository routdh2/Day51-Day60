//Problem Statement: https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //step-1 find out the initial gas station to start journey
        for(int i=0;i<gas.length;i++) {
            if(gas[i]>=cost[i]) {
                if(canCompleteJourney(gas,cost,i))
                    return i;
            }
        }
        return -1;    
    }
    
    public boolean canCompleteJourney(int[] gas,int[] cost, int index) {
        int startIndex=index;
        int gasNeeded=cost[index];
        int gasIHave=gas[index];
        do {
            if(gasNeeded<=gasIHave) {
                index++;
                if(index==gas.length)
                    index=0;
                gasIHave=gasIHave-gasNeeded;
                gasNeeded=cost[index];
                gasIHave+=gas[index];
            }
            else {
                return false;
            }
            
        } while(index!=startIndex);
        return true;
    }
}
