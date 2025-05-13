class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum =0;
        for(int i=0; i<k;i++){
            sum +=nums[i];
        }

        double average =sum;
        for(int i=k;i<nums.length;i++){
            sum = sum + nums[i] -nums[i-k];
            average = Math.max(average, sum);
        }
        return average/k;
    }
}