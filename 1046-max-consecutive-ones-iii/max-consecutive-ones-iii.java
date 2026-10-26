class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int maxLen = 0;
        int zero_flip = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end]==0){
                zero_flip++;
            }
            if(zero_flip>k){
                while(zero_flip>k){
                    if(nums[start]==0){
                        zero_flip--;
                    }
                    start++;
                }
            }
            int len = end-start+1;
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}