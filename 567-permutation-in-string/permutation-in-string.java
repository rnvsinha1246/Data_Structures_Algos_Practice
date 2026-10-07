class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] freqS1 = new int[26];
        for(char ch : s1.toCharArray()){
            freqS1[ch - 'a']++;
        }
        int[] window = new int[26];
        for(int i = 0; i < s1.length(); i++){
            char ch = s2.charAt(i);
            window[ch - 'a']++;
        }
        if(Arrays.equals(freqS1, window)){
            return true;
        }
        for(int i = s1.length(); i < s2.length(); i++){
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - s1.length()) - 'a']--;
            if(Arrays.equals(freqS1, window)){
                return true;
            }
        }
        return false;
    }
}