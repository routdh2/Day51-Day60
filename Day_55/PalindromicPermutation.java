package june11;

import java.util.HashMap;
//Problem Statement: https://leetcode.com/articles/palindrome-permutation/
public class PalindromicPermutation {
	
	private static boolean palindromicPermutation(String str) {
		if(str==null || str.length()==0)
			return true;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char key = str.charAt(i);
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		int noOfOdds=0;
		for(Character key : map.keySet()) {
			int value = map.get(key);
			if(value%2==1)
				noOfOdds++;
		}
		return noOfOdds<=1;
	}

	public static void main(String[] args) {
		System.out.println(palindromicPermutation("code"));
		System.out.println(palindromicPermutation("aab"));
		System.out.println(palindromicPermutation("carerac"));

	}

}
