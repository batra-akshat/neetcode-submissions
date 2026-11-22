class MinStack {
public:
    vector<int> a;
    vector<int> pre;
    MinStack() {
        a.clear();
        pre.clear();    
    }
    
    void push(int val) {
        a.push_back(val);
        if(pre.size() >= 1) {
            int lastel = pre.back();
            pre.push_back(min(lastel, val));
        } else {
            pre.push_back(val);
        }   
    }
    
    void pop() {
        a.pop_back();  
        pre.pop_back();
    }
    
    int top() {
        return a[a.size()-1];
    }
    
    int getMin() {
        return pre.back();
    }
};
