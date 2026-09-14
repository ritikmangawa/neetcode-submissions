
 class Solution {
    public int countSubstrings(String s) {
        //one start with i = 0and another from i = 1 for odd and even size of string
        String res = "";
        int reslen = 0;
        int count = 0;
        
        
        for(int i = 0; i < s.length(); i++){
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                // if(r - l + 1 > reslen){
                //     res = s.substring(l, r+1);
                //     reslen = r - l + 1;
                // } 
                count++;
                l--;
                r++;
            }
        }
        for(int i = 0; i < s.length(); i++){
            int l = i;
            int r = i+1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                // if(r - l + 1 > reslen){
                //     res = s.substring(l, r+1);
                //     reslen = r - l + 1;
                // } 
                count++;
                l--;
                r++;
            }
        }
        return count;

        
    }
}