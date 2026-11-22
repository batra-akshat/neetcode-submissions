class Solution {
    List<String> ans;
    Map<Integer, List<Character>> mp;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        mp = new HashMap<>();
        mp.put(2, List.of('a', 'b', 'c'));
        mp.put(3, List.of('d', 'e', 'f'));
        mp.put(4, List.of('g', 'h', 'i'));
        mp.put(5, List.of('j', 'k', 'l'));
        mp.put(6, List.of('m', 'n', 'o'));
        mp.put(7, List.of('p', 'q', 'r', 's'));
        mp.put(8, List.of('t', 'u', 'v'));
        mp.put(9, List.of('w', 'x', 'y', 'z'));
        if(digits.isEmpty()) {
            return ans;
        }
        backTrack(digits, new StringBuilder(), 0);
        return ans;
    }

    private void backTrack(String digits, StringBuilder builder, int start) {
        if (start == digits.length()) {
            var copy = new StringBuilder(builder);
            ans.add(copy.toString());
            return;
        }
        char c = digits.charAt(start);
        int digit = c - '0';
        var charsAssociated = mp.get(digit);
        for (var letter : charsAssociated) {
            builder.append(letter);
            backTrack(digits, builder, start + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}