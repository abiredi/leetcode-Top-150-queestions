class Solution {
    public int removeElement(int[] nums, int val) {
       int j = nums.length;

       for(int i=nums.length-1; i>=0; i--){
        if(i!=j && nums[i]==val){
            int temp = nums[i];
            nums[i] = nums[--j];
            nums[j] = temp;
        }}
        return j;
       }  
    }