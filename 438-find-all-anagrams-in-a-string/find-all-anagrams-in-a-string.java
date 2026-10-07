class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<>();
        }
        int[] freqp = new int[26];
        for(char ch : p.toCharArray()){
            freqp[ch-'a']++;
        }
        int[] freqs = new int[26];
        for(int i = 0; i < p.length(); i++){
            freqs[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if(Arrays.equals(freqs, freqp)){
            res.add(0);
        }
        for(int i = p.length(); i < s.length(); i++){
            char ch = s.charAt(i);
            freqs[ch-'a']++;
            freqs[s.charAt(i - p.length()) - 'a']--;
            if(Arrays.equals(freqs, freqp)){
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}