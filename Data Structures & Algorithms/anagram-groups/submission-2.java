class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> frequencyArrayToStrings = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(int i = 0; i <str.length();i++) {
                freq[str.charAt(i) - 'a']++;
            }
            var freqString = Arrays.toString(freq);
            if(frequencyArrayToStrings.containsKey(freqString)) {
                frequencyArrayToStrings.get(freqString).add(str);
            } else {
                frequencyArrayToStrings.put(freqString, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(frequencyArrayToStrings.values());
    }
}