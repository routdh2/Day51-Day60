//Problem Statement: https://leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int currLightest=0,currHeaviest=people.length-1;
        int count=0;
        while(currLightest<=currHeaviest) {
            if(people[currLightest]+people[currHeaviest]<=limit) {
                currLightest++;
            }
            currHeaviest--;
            count++;
        }
        return count;
        
    }
}
