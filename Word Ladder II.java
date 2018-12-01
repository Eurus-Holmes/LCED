class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        wordSet.add(beginWord);

        // 记录一个单词 BFS 的下一层节点
        Map<String, List<String>> neighbors = new HashMap<>();
        // 记录该单词与 beginWord 之间的距离，同时也充当了 visitedSet 的作用
        Map<String, Integer> distance = new HashMap<>();
        List<List<String>> rst = new ArrayList<>();

        bfs(beginWord, endWord, wordSet, neighbors, distance);
        dfs(beginWord, endWord, neighbors, distance, new LinkedList<>(), rst);

        return rst;
    }

    // 利用 bfs 找到最短路径，并构建出关系图
    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> neighbors, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                // 遇到 endWord 就退出，其他的信息我们已经不需要了
                if (curr.equals(endWord)) {
                    break;
                }

                List<String> currNeig = getNeighbors(curr, wordSet);
                Iterator<String> iterator = currNeig.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    // 如果之前没有遍历过该单词，则将其加入到队列中，并记录 distance 信息
                    if (!distance.containsKey(word)) {
                        queue.offer(word);
                        distance.put(word, distance.get(curr) + 1);
                    }
                }
                // 记录当前单词节点对应的 下一级节点的信息（邻居信息）
                neighbors.put(curr, currNeig);
            }
        }
    }

    // 遍历获取邻居节点，与 Word Ladder 中的方法相同
    private List<String> getNeighbors(String curr, Set<String> wordSet) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = curr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == old) {
                    continue;
                }
                chars[i] = ch;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)) {
                    neighbors.add(nextWord);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    // dfs 遍历求解所有路径
    private void dfs(String currWord, String endWord, Map<String, List<String>> neighbors, Map<String, Integer> distance,
                     LinkedList<String> list, List<List<String>> rst) {
        list.add(currWord);
        if (currWord.equals(endWord)) {
            rst.add(new LinkedList<>(list));
        } else {
            for (String neig : neighbors.get(currWord)) {
                if (neig == null) {
                    continue;
                }
                // 利用到了 distance 信息，只有当 neig 是 bfs 的下一级节点时才遍历
                // 因为不是所有的 neigh 都是到 endWord 的最短路径
                if (distance.get(neig) == distance.get(currWord) + 1) {
                    dfs(neig, endWord, neighbors, distance, list, rst);
                }
            }
        }
        list.remove(list.size() - 1);
    }
}
