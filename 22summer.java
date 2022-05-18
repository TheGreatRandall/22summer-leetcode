May 8 th 3. Longest Substring Without Repeating Characters-Medium

Solution slide window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> tempLongestSubstring = new HashMap<>();
        int result = 0;
        int startPoint = 0;

        for (int endPoint = 0; endPoint < s.length(); endPoint++) {
            char rightEnd = s.charAt(endPoint);
            if (tempLongestSubstring.containsKey(rightEnd)) {
                startPoint = Math.max(startPoint, tempLongestSubstring.get(rightEnd) + 1);// tricky one

            }
            tempLongestSubstring.put(rightEnd, endPoint);
            result = Math.max(result, endPoint - startPoint + 1);

        }

        return result;

    }}

    ---------------------------------------------------------------------May 9 th 2.

    Add two
    numbers get
    familiar with
    node structure

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1; 
        ListNode q = l2;
        ListNode cur = result;
        int carry = 0;
        while(p != null || q!= null){
            int index1 = 0;
            int index2 = 0;
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p != null){
                p= p.next;
            }
            if(q != null){
                q = q.next;
            }
            
                
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
                
        }
        return result.next;//to get rid of the first 0, brilliant


May 18th 我是罪人 划了一周
5. Longest Palindromic DP

class Solution {
    
    //dp
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int result = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i< len; i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int j = 1; j <len;j++){
            for(int i = 0; i < j; i++){
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                
                if(dp[i][j]&&j - i + 1 > result){
                    result = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+result);
        
        
        
    
        
        
    }
    
    

}

567. permutation in string. //slide window and map 

--------my solution with bug
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowLen = s1.length();
        int left = 0;
        boolean result = false;
        while(result == false && (left + windowLen <= s2.length())){
            result = ifPermutation(s1,s2.substring(left,left+windowLen));


            left++;
        }
        return result;
        
    }
    public static boolean ifPermutation(String str, String pattern){
        boolean result = true;
        //assume str.length = pattern.length

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
          if(map1.containsKey(str.charAt(i))){
            map1.put(str.charAt(i),map1.get(str.charAt(i)+1));
          }else{
            map1.put(str.charAt(i),1);
          }

          if(map2.containsKey(pattern.charAt(i))){
            map2.put(pattern.charAt(i),map2.get(pattern.charAt(i)+1));
          }else{
            map2.put(pattern.charAt(i),1);
          }
        }
        int j = 0;
        while(result == true && j < str.length()){
            char s = str.charAt(j);
            
            if(map2.containsKey(s) == false){
                result = false;
            }else if(map2.get(s) != map1.get(s)){
                result = false;
            }
            
            
            j++;
        } 



        return result;
      }
}
