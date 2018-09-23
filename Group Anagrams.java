class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
			return new ArrayList<>();
		// 此排序是为了让每个List<String>的结果按照字典序输出
		// 但是并不需要，此题没要求
		Arrays.sort(strs);
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
 
			char[] cs = str.toCharArray();
			// 将char数组按照字典顺序排序
			Arrays.sort(cs);
			String sortStr = String.valueOf(cs);
			// 排序后的String作为key，
			if (!map.containsKey(sortStr))
				map.put(sortStr, new ArrayList<>());
			map.get(sortStr).add(str);
		}
		// 注意ArrayList的构造方法的应用
		return new ArrayList<>(map.values());


    }
}
