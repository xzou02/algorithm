public class LongestPalindromicSubstring {
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
            Example 2:

    Input: "cbbd"
    Output: "bb"

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            int max = 0, len1 = 0, len2 = 0, start = 0, end = 0;
            for (int i = 0; i < s.length(); i++){
                //two cases: one for odd # palindrome one for even # palindrome
                len1 = expandaroundcenter(s,i,i);
                len2 = expandaroundcenter(s,i,i+1);
                max = Math.max(max, len2);
                max = Math.max(max, len1);

                // = for only one letter such as "a"
                if (max >= end - start + 1){
                    start = i - (max-1) / 2;
                    end = i + max/2 + 1;
                }
            }

            if (end == s.length()) return s.substring(start);

            return s.substring(start, end);
        }

        public int expandaroundcenter(String s, int left, int right){
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;

            }
            //pay attention to final left&right position
            return right - left - 1;
        }
    }
}
