// class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         for(int num : arr){
//             freq.put(num, freq.getOrDefault(num, 0) + 1);
//         }
//         //store the frequency count of elements in the unordered list
//         Set<Integer> freqSet = new HashSet<>(freq.values());

//         //if the set size is equal to map size then it implies frequency counts are unique
//         return freq.size() == freqSet.size();
//     }
// }
//hashmap is to store unique elements and hashset is to count the number of elements in unordered list
class Solution{
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Set<Integer> freqSet = new HashSet<>(freq.values());
        return freq.size() == freqSet.size();
    }
}