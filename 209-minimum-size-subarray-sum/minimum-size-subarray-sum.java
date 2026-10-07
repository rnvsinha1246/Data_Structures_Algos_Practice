class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = nums.length + 1;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLen==nums.length+1 ? 0 : minLen;
    }
}