class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int index=10;index<=s.length();index++){
            // 从第10位开始作为结尾，位移一位，比较一次子串
            String substr = s.substring(index-10, index);
            if(map.containsKey(substr)){
                // 如果是第一次遇到，则加入结果
                if(map.get(substr)==1){
                    res.add(substr);
                }
                // 标记为已经遇到过一次了
                map.put(substr, 2);
            }else{
                // 如果不存在，则加入表中
                map.put(substr, 1);
            }
        }
        return res; 
    }
}
