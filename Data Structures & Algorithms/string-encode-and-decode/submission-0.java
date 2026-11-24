class Solution {

    public String encode(List<String> strs) {
        var builder = new StringBuilder();
        for(String str : strs) {
            var length = str.length();
            builder.append(length);
            builder.append('#');
            builder.append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int length = 0;
            while (str.charAt(i) -'0' >=0) {
                length *= 10;
                length += (str.charAt(i) -'0');
                i++;
            }
            ans.add(str.substring(i+1, i+1+length));
            i+=(length+1);
        }
        return ans;
    }
}