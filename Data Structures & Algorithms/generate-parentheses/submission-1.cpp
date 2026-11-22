class Solution {
public:

 void backtrack(int closed, int open, vector<string>& res, string str, int n) {
        if (closed == open && open == n) {
            res.push_back(str);
            return;
        }
        if (open < n) backtrack(closed, open + 1, res, str + '(', n);
        if (closed < open) backtrack(closed + 1, open, res, str + ')', n);
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        backtrack(0, 0, res, "", n);
        return res;
    }
};
