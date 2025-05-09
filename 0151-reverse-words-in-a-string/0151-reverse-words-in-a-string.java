// class Solution {
//     public String reverseWords(String s) {
        
//     }
// }
class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        String[] strings = s.split("\\s+");

        StringBuilder output = new StringBuilder();

        for(int i = strings.length - 1 ; i>=0 ; i--){
            output.append(" ");
            output.append(strings[i]);
        }

        return output.toString().trim();
        
    }
}