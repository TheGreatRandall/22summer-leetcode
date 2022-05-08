May 8th
3. Longest Substring Without Repeating Characters -Medium

Solution slide window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> tempLongestSubstring = new HashMap<>();
        int result = 0;
        int startPoint = 0;
        
        for (int endPoint = 0;endPoint < s.length();endPoint++){
            char rightEnd = s.charAt(endPoint);
            if(tempLongestSubstring.containsKey(rightEnd)){
                startPoint = Math.max(startPoint, tempLongestSubstring.get(rightEnd)+1);//tricky one
                
                
            }
            tempLongestSubstring.put(rightEnd,endPoint);
            result = Math.max(result, endPoint - startPoint +1);
         
        }
        
        return result;
        
        
    }
}
