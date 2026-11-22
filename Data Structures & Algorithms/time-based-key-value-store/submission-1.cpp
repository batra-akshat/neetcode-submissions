class TimeMap {
private:
    unordered_map<string, vector<pair<int, string>>> timeMap;
public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        timeMap[key].push_back({timestamp, value});
    }
    
    string get(string key, int timestamp) {
        auto st = timeMap[key];
        auto it = upper_bound(st.begin(), st.end(), timestamp,
                        [](int t, const pair<int,string>& p) {
                            return t < p.first;
                              });
        if (it == st.begin()) return "";
        it--;
        return it->second;
    }
};