class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0) sum -= 1;
            else sum += 1;

            if(mp.containsKey(sum)){
                int idx = mp.get(sum);
                maxLen = Math.max(maxLen, i - idx);
            }
            else{
                mp.put(sum, i);
            }
        }
        return maxLen;
    }
}