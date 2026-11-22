class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        TreeSet<Integer> st = new TreeSet<>();
        TreeSet<Integer> st2 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else if (s.charAt(i) == '*') {
                st2.add(i);
            } else {
                if (st.isEmpty() && st2.isEmpty()) {
                    return false;
                }
                if (!st.isEmpty()) {
                    st.remove(st.last());
                } else {
                    st2.remove(st2.last());
                }
            }
        }
        for(var idx : st) {
            Integer idxInSt2 = st2.higher(idx);
            if(idxInSt2 == null) {
                return false;
            }
            st2.remove(idxInSt2);
        }
        return true;
    }
}