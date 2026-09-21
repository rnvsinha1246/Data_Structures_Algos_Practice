class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int res = 0;
        int prefixSum = 0;

        for(int num : nums){
            prefixSum += num;
            if(mp.containsKey(prefixSum-k)){
                res += mp.get(prefixSum - k);
            }
            if(mp.containsKey(prefixSum)){
                mp.put(prefixSum, mp.get(prefixSum) + 1);
            }else{
                mp.put(prefixSum, 1);
            }
        }

        return res;
    }
}