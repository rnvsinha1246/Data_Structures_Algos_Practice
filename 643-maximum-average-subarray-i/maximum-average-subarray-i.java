class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int n = nums.length;
        double maxAvg = (double) sum/k;
        for(int i = k; i < n; i++){
            double currAvg = 0.0;
            sum -= nums[i-k];
            sum += nums[i];
            currAvg = (double) sum/k;
            maxAvg = Math.max(maxAvg, currAvg);
        }
        return maxAvg;
    }
}