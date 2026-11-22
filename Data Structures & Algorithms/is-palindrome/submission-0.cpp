class Solution {
public:
    bool isPalindrome(string s) {
       int n = s.size();
       int i=0,j=n-1;
       while(i < j) {
        if(!iswalnum(s[i])) {
            cout<<"Not alphanumeric"<<" "<<"Char is" <<s[i]<<"\n";
            i++;
        } else if(!iswalnum(s[j])) {
            cout<<"Not alphanumeric"<<" "<<"Char is" <<s[j]<<"\n";
            j--;
        } else {
            if(tolower(s[i]) != tolower(s[j])) {
                return false;
            }
            i++;
            j--;
        }
       }
       return true; 
    }
};
