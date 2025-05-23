class Solution {
    
    public double myPow(double x, int n){
        return binaryExp(x,(long)n);
    }
    
    public double binaryExp(double x, long n) {
        if(n==0) return 1;
        if(n<1){
            return 1.0/binaryExp(x,-1*n);
        }
        if(n % 2 == 1){
            return x * binaryExp(x*x, (n-1)/2);
        }
        return binaryExp(x*x, n/2);
    }
}