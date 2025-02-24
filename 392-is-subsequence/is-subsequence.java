class Solution {
    public boolean isSubsequence(String s, String t) {

        int i=0, j=0;
        
        while(i<s.length() && j<t.length()){

            if(s.charAt(i) == t.charAt(j)){
                i++;
            }

            j++;
        }

        return i == s.length();
        
    }
}

class Solution1 {
    public boolean isSubsequence(String s, String t) {

        int i=0, j=-1;
        
        int n =s.length();

        while(i<n){
            char ch = s.charAt(i++);
            j++;
            while(j<t.length()){
                if(t.charAt(j) == ch)break;
                j++;
            }

            if(j == t.length()) return false;
        }

        return true;
        
    }
}