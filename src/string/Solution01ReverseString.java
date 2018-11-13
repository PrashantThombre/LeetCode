package string;

public class Solution01ReverseString {

	/*
	 * Link:
	 * https://leetcode.com/explore/interview/card/top-interview-questions-
	 * easy/127/strings/879/
	 * https://leetcode.com/problems/reverse-string/description/
	 * 
	 * Problem Title: Reverse String
	 * 
	 * Problem Description: Write a function that takes a string as input and
	 * returns the string reversed.
	 * 
	 * 
	 * 
	 * Ex 1: Input: "hello" Output: "olleh"
	 */

	public String reverseString(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] charArr = s.toCharArray();

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (charArr[start] == charArr[end]) {
				start++;
				end--;
				continue;
			}
			char temp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = temp;

			start++;
			end--;
		}

		return new String(charArr);
	}

	/*
	 * Link: https://leetcode.com/problems/reverse-string-ii/description/
	 * 
	 * Problem Title: Reverse String II
	 * 
	 * Problem Description: Given a string and an integer k, you need to reverse
	 * the first k characters for every 2k characters counting from the start of
	 * the string. If there are less than k characters left, reverse all of
	 * them. If there are less than 2k but greater than or equal to k
	 * characters, then reverse the first k characters and left the other as
	 * original.
	 * 
	 * 
	 * 
	 * Ex 1: Input: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
	 * 
	 * Restrictions: The string consists of lower English letters only. Length
	 * of the given string and k will in the range [1, 10000]
	 */

	public String reverseString_II(String s, int k) {
		char[] c = s.toCharArray();
		int sLen = s.length();
		int charToRev = k;
		for (int i = 0; i < sLen; i += (2 * k)) {
			int start = i;
			int end = (start + charToRev - 1 < sLen - 1) ? (start + charToRev - 1)
					: sLen - 1;
			while (start < end) {
				char temp = c[start];
				c[start] = c[end];
				c[end] = temp;
				start++;
				end--;
			}
		}
		return new String(c);
	}
}
