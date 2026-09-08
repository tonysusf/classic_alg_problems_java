import java.util.*;

/*
* javac LongestNonRepeatSubstring.java; java -ea LongestNonRepeatSubstring
*/


class LongestNonRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> lookup = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(lookup.containsKey(s.charAt(i)) && lookup.get(s.charAt(i)) >= left) {
                left = lookup.get(s.charAt(i)) + 1;
            }
            lookup.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestNonRepeatSubstring s = new LongestNonRepeatSubstring();
        assert s.lengthOfLongestSubstring("abcabcbb") == 3;

        assert s.lengthOfLongestSubstring("bbbbb") == 1;

        assert s.lengthOfLongestSubstring("pwwkew") == 3;
    }
}