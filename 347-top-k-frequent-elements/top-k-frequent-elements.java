class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int n : nums){
            if(freqMap.containsKey(n)){
                freqMap.put(n, freqMap.get(n) + 1);
            }
            else{
                freqMap.put(n, 1);
            }
        }
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int counter = 0;
        for(int pos = bucket.length-1; pos >= 0 && counter < k; pos--){
            if(bucket[pos] !=null){
                for(Integer number : bucket[pos]){
                    res[counter++] = number;
                }
            }
        }
        return res;
    }
}