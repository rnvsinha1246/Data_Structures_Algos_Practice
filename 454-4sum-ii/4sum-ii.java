class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums1.length;
        int totalCount = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = nums1[i] + nums2[j];
                freq.put(sum, freq.getOrDefault(sum, 0) + 1);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = nums3[i] + nums4[j];
                int toFind = -1 * sum;
                if(freq.containsKey(toFind)){
                    totalCount += freq.get(toFind);
                }
            }
        }
        return totalCount;
    }
}