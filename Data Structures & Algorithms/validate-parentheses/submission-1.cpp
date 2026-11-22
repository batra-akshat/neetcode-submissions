class Solution {
public:
    bool isValid(string s) {
        int n = s.size();
        stack<int> st;
        for(int i=0;i<n;i++) {
            if(s[i] == '(' || s[i] == '{' || s[i] == '[') {
                st.push(s[i]);
            } else {
                // closing brace
                if(st.empty()) {
                    return false;
                }
                if(!isInverse(st.top(), s[i])) {
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();     
    }
    bool isInverse(char a, char b) {
        return (a == '(' && b ==')') || 
        (a == '{' && b=='}') || 
        (a == '[' && b==']');
    }
};
