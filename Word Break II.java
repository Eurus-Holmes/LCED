class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
    }
    
    private List<String> DFS(String s, List<String> wordDict, HashMap<String, ArrayList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 0){
			res.add("");
			return res;
		}
		for (String subStr : wordDict) {
			if (s.startsWith(subStr)) {
				for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
					res.add(subStr + (str == "" ? "" : " ")+ str);
 
				}
 
			}
		}
		map.put(s, res);
		return res;
 
	}
}
