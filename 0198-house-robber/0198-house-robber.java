class Solution{
    public int rob(int[] nums){
        int N =nums.length;

        if(N==0){
            return 0;
        }
        //tc:O(n);SC:O(n)
        int[] maxRobAmount= new int[N+1];
        //base case
        maxRobAmount[N]=0;
        maxRobAmount[N-1]=nums[N-1];
        // DP table calculations.
        for(int i=N-2;i>=0;--i){
            maxRobAmount[i]=Math.max(maxRobAmount[i+1],maxRobAmount[i+2]+nums[i]);
        }
        return maxRobAmount[0];
    }
}