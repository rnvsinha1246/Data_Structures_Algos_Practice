class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[rightMax.length-1] = height[height.length-1];
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for(int i = rightMax.length-2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int[] water = new int[height.length];
        int totalWater = 0;
        for(int i = 0; i < water.length; i++){
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }
}