// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         Map<Character, Character> sMap = new HashMap<>();
//         Map<Character, Character> tMap = new HashMap<>();

//         for(int i=0; i<s.length(); i++){
//             if(!sMap.containsKey(s.charAt(i))){
//                 if(tMap.containsKey(t.charAt(i))) return false;
//                 sMap.put(s.charAt(i), t.charAt(i));
//                 tMap.put(t.charAt(i), s.charAt(i));
//             }

//             if(!sMap.get(s.charAt(i)).equals(t.charAt(i))) return false;
//         }

//         return true;
//     }
// }
class Solution {
    private String transformString(String s){
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for(int i =0; i<s.length(); i++){
            char c1 = s.charAt(i);

            if(!indexMapping.containsKey(c1)){
                indexMapping.put(c1,i);
            }
            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}