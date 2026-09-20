class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        int count = 1;
        for(char ch : s.toCharArray()){
            int revInd = 26 - (ch - 'a');
            revInd = revInd * count;
            count++;
            res+=revInd;
        }
        return res;
    }
}