class Solution {
public:
    int evalRPN(vector<string>& exp) {
        int n = exp.size();
        stack<int> st;
        try {
            for(int i = 0 ; i <n;i++) {
                if(exp[i] == "+") {
                    int x = st.top();
                    st.pop();
                    int y = st.top();
                    st.pop();
                    st.push(x+y);
                } else if(exp[i] == "-") {
                    int x = st.top();
                    st.pop();
                    int y = st.top();
                    st.pop();
                    st.push(y-x);
                } else if(exp[i] == "*") {
                    int x = st.top();
                    st.pop();
                    int y = st.top();
                    st.pop();
                    st.push(x*y);
                } else if(exp[i] == "/") {
                    int x = st.top();
                    st.pop();
                    int y = st.top();
                    st.pop();
                    st.push(y/x);
                } else{
                    st.push(stoi(exp[i]));
                }
            }
        } catch(runtime_error e) {
            cout<<"Exception "<<e.what()<<'\n';
        }
        return st.top(); 
    }
};
