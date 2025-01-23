class Solution {
    public int removeDuplicates(int[] nums) {
         int sortedIndex = 0;
        int checkedIndex = 0;

        for(int i=1; i<nums.length ; i++){
            if(nums[sortedIndex] < nums[++checkedIndex]){
                nums[++sortedIndex] = nums[checkedIndex];
            }
        }

        return sortedIndex + 1;
    }
}