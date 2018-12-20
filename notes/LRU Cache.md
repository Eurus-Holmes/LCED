# 原题
设计并实现一个支持近期最少使用缓存的数据结构。要支持存和取两个操作。根据键取值时，如果键对应的值不存在，则返回-1。存键值对时，如果容量已经满了，要把最近最少使用的键值对去除后再插入。

注意点：

  - 无
  
例子:

```
Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

# 解题思路
这道题是一个数据结构设计题，在leetcode里面就这么一道，还是挺经典的一道题，可以好好看看。

这道题要求设计实现LRU cache的数据结构，实现set和get功能。学习过操作系统的都应该知道，cache作为缓存可以帮助快速存取数据，但是缺点是容量较小。
这道题要求实现的cache类型是LRU，LRU的基本思想就是“最近用到的数据被重用的概率比较早用到的大的多”，是一种更加高效的cache类型。

解决这道题的方法是：双向链表+HashMap。

“为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们将双向链表连接Cache中的数据项，并且保证链表维持数据项从最近访问到最旧访问的顺序。 
每次数据项被查询到时，都将此数据项移动到链表头部（O(1)的时间复杂度）。这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，
而没有被使用的内容就向链表的后面移动。当需要替换时，链表最后的位置就是最近最少被使用的数据项，我们只需要将最新的数据项放在链表头部，
当Cache满时，淘汰链表最后的位置就是了。 ”

        “注： 对于双向链表的使用，基于两个考虑。

         首先是Cache中块的命中可能是随机的，和Load进来的顺序无关。

         其次，双向链表插入、删除很快，可以灵活的调整相互间的次序，时间复杂度为O(1)。”

解决了LRU的特性，现在考虑下算法的时间复杂度。为了能减少整个数据结构的时间复杂度，就要减少查找的时间复杂度，所以这里利用HashMap来做，
这样时间复杂度就是O(1)。

所以对于本题来说：

get(key): 如果cache中不存在要get的值，返回-1；如果cache中存在要找的值，返回其值并将其在原链表中删除，然后将其作为头结点。

set(key,value)：当要set的key值已经存在，就更新其value， 将其在原链表中删除，然后将其作为头结点；当要set的key值不存在，
就新建一个node，如果当前len<capacity,就将其加入hashmap中，并将其作为头结点，更新len长度，否则，
删除链表最后一个node，再将其放入hashmap并作为头结点，但len不更新。

原则就是：对链表有访问，就要更新链表顺序。 

# Reference
  - [LeetCode – LRU Cache (Java)](https://www.programcreek.com/2013/03/leetcode-lru-cache-java/)
