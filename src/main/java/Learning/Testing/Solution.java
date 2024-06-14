package Learning.Testing;

public class Solution 
{
	
	    public static int longestSemiAlternatingSubstring(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }

	        int maxLen = 1; // Minimum length is 1 for a non-empty string

	        int count = 1; // Count of consecutive repeating characters
	        for (int i = 1; i < s.length(); i++) {
	            if (s.charAt(i) == s.charAt(i - 1)) {
	                count++;
	            } else {
	                count = 1; // Reset count for a different character
	            }

	            if (count <= 2) {
	                maxLen = Math.max(maxLen, i + 1); // Update maxLen for valid substring
	            }
	        }

	        return maxLen;
	    }

	    public static void main(String[] args) {
	        // Test the function with an example string
	        String input = "baaabbabbb";  
	        int result = longestSemiAlternatingSubstring(input);
	        System.out.println("Length of longest semi-alternating substring: " + result);
	    }
	}


