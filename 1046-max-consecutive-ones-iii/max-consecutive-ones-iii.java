class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            
            if (nums[right] == 0) {
                k--;
            }
            
            if (k < 0) {

                if(nums[left] == 0){
                    k++;
                }

                left++;
            }
        }     
        return right - left;
    }
}

class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            
            if (nums[right] == 0) {
                k--;
            }
            
            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }     
        return right - left;
    }
}

class Solution1 {
    public int longestOnes(int[] nums, int k) {

        int c = 0;
        int count = 0;
        int startIndex = 0;

        for(int i=0; i< nums.length ; i++){

            if(nums[i] == 0){
                c++;
            }  

            if(c == k+1){
                    while(nums[startIndex++] !=0);
                    c--;
            }

            count = Math.max(count, i - startIndex + 1);

        }
             
        return count;
    }
}
