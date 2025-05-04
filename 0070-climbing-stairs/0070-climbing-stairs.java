public class Solution1 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        //TC:-O(N);;SC:-o(1)
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

class Solution{
    public int climbStairs(int n){
        if(n==1) return 1;
        if(n<0) return 0;
//TC;o(n);sc:o(n)
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}