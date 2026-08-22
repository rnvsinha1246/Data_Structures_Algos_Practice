class Solution {
    public boolean checkDivisibility(int n) {
        int digSum = 0;
        int digProd = 1;
        int temp = n;
        while(temp>0){
            int dig = temp%10;
            digSum += dig;
            digProd*= dig;
            temp = temp/10;
        }
        int s = digSum+digProd;
        if(n%s==0) return true;
        return false;
    }
}