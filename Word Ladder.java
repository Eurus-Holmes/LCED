class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (beginWord == null || endWord == null 
            || beginWord.length() == 0 || endWord.length() == 0
				|| beginWord.length() != endWord.length())
			return 0;
		// 此题关键是去重，还有去除和beginWord，相同的单词
		Set<String> set = new HashSet<String>(wordList);
		if (set.contains(beginWord))
			set.remove(beginWord);
		Queue<String> wordQueue = new LinkedList<String>();
		int level = 1; // the start string already count for 1
		int curnum = 1;// the candidate num on current level
		int nextnum = 0;// counter for next level
		// 或者使用map记录层数
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put(beginWord, 1);
		wordQueue.add(beginWord);
 
		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();
			curnum--;
			// int curLevel = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] wordunit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordunit[i] = j;
					String temp = new String(wordunit);
 
					if (set.contains(temp)) {
						if (temp.equals(endWord))
							// return curLevel + 1;
							return level + 1;
						// map.put(temp, curLevel + 1);
						nextnum++;
						wordQueue.add(temp);
						set.remove(temp);
					}
				}
			}
			if (curnum == 0) {
				curnum = nextnum;
				nextnum = 0;
				level++;
			}
		}
		return 0;
    }
}
