class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length==0){
        return 0;
       }
       
       int i=1;//pointer to iterate throughout the array
       int j=1;//Pointer to track position for valid elements
       int count =1;

       while(i<nums.length){
        if(nums[i]==nums[i-1]){
            count++;
            if(count>2){
                i++;
                continue;
            }
        }else{
            count=1;
        }
        nums[j] = nums[i];
            j++;
            i++;
       }
        return j;
    }
}