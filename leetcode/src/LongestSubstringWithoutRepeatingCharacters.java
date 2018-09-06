public class LongestSubstringWithoutRepeatingCharacters {
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", which the length is 3.
    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if (! map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                int tmp;
                tmp = map.get(s.charAt(i));
                if (tmp >= j){
                    j = tmp + 1;
                }
                map.put(s.charAt(i), i);
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
