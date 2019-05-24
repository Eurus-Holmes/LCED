# 原题
设计一个数据结构支持在O(1)时间内完成如下操作：

insert(val): 如果集合中不包含val，则插入val

remove(val): 如果集合中包含val，则移除val

getRandom: 从现有集合中随机返回一个元素，每个元素被返回的概率应该相等

注意点：

  - 无

例子：

```
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
```

# 解题思路
### 哈希表 + 数组 （HashMap + Array）

利用数组存储元素，利用哈希表维护元素在数组中的下标

由于哈希表的新增/删除操作是O(1)，而数组的随机访问操作开销也是O(1)，因此满足题设要求

记数组为dataList，哈希表为dataMap

```
insert(val): 将val添至dataList末尾，并在dataMap中保存val的下标idx

remove(val): 记val的下标为idx，dataList末尾元素为tail，弹出tail并将其替换至idx处，在dataMap中更新tail的下标为idx，最后从dataMap中移除val

getRandom: 从dataList中随机选取元素返回
```
