class Solution {
    public String removeStars(String s) {
       //lets create a stack
       Stack<Character> st = new Stack<>();

       for(int i =0; i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
       }
       StringBuilder result = new StringBuilder();
       while(!st.isEmpty()){
        result.append(st.pop());
       } 
       return result.reverse().toString();
    }
}