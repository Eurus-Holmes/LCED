class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            for (int i = k - 1; i >= 1; i--) {
                list.set(i, list.get(i) + list.get(i - 1));
            }
            list.add(1);
        }
        return list;
    }
}
