class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backTrack(String s, int start, List<String> strings) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(strings));
            return; // Add return here for clarity
        }

        // Only one loop: try all possible endings from current start position
        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                strings.add(substring);
                backTrack(s, end + 1, strings);  // Move to next position after current substring
                strings.remove(strings.size() - 1);  // Backtrack
            }
        }
    }

    boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


