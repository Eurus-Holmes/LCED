# 原题
要求实现一个数据结构（数允许重复），可以支持插入，删除，随机数生成。 他们的复杂度均要求O(1)

注意点：

  - 无

例子：

```
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
```

# 解题思路
其实和上一题  [Insert Delete GetRandom O(1)](https://www.hrwhisper.me/leetcode-insert-delete-getrandom-o1/) 差不多，
只不过这题允许重复，把字典里换成一个哈希表的set即可(注意，不可以是list)

比如如下的数据，list无法保证顺序！

```
["RandomizedCollection", "insert", "insert", "insert", "insert", "insert", "insert", "insert", "insert","remove", "remove", "remove", "remove", "remove", "remove"]
[[], [3], [4], [5], [6], [1], [2], [1], [2], [3], [4], [5], [6], [2], [2]]
```

