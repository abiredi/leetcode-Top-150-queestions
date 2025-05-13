class Solution {
    public int maxVowels(String s, int k) {
        int sum=0;
        for(int i=0; i<k;i++){
            if(isVowel(s.charAt(i))){
                sum++;
            }
        }

        int currentVowel = sum;
        for(int i=k; i<s.length();i++){
            if(isVowel(s.charAt(i-k))) currentVowel--;

            if(isVowel(s.charAt(i))) currentVowel++;
            sum = Math.max(sum, currentVowel);
        }
        return sum;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }    
        
    }
