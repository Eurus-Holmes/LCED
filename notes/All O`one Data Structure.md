# 原题
设计数据结构支持下列操作：

```
Inc(Key) - 新增值为1的key。如果key存在则将其值加1。key确保是非空字符串。
Dec(Key) - 将已存在的key值减1。如果key值已经是1，则将其移除。如果key不存在，函数什么也不做。
GetMaxKey() - 返回值最大的key中的1个。如果不存在，则返回空字符串""。
GetMinKey() - 返回值最小的key中的1个。 如果不存在，则返回空字符串""。
```

挑战：所有操作用O(1)时间复杂度完成。

注意点：

  - 无

例子：

无

# 解题思路
### 双向链表（Doubly Linked List） + 哈希表（Hash Table）

首先定义双向链表节点：KeyNode（Key节点）与ValueNode（Value节点）。

```
KeyNode中保存key（键），value（值），prev（前驱），next（后继）

ValueNode中保存value（值）、prev（前驱）、next（后继）、first（指向第一个KeyNode）
```

在数据结构AllOne中维护如下属性：

```
keyDict：从key到KeyNode的映射

valueDict：从value到ValueNode的映射

head：指向最小的ValueNode

tail：指向最大的ValueNode
```

整体数据结构设计如下图所示：

```
head --- ValueNode1 ---- ValueNode2 ---- ... ---- ValueNodeN --- tail 
              |               |                       |               
            first           first                   first             
              |               |                       |               
           KeyNodeA        KeyNodeE                KeyNodeG           
              |               |                       |               
           KeyNodeB        KeyNodeF                KeyNodeH           
              |                                       |               
           KeyNodeC                                KeyNodeI           
              |                                                       
           KeyNodeD                                                   
```

数据结构操作实现如下：

**Inc(Key) / Dec(Key)：**

```
首先从keyDict中找到对应的KeyNode，然后通过KeyNode的value值，从valueDict找到对应的ValueNode

如果ValueNode的next节点不等于value +/- 1，则在其右侧/左侧插入一个值为value +/- 1的新ValueNode节点

将KeyNode的value值+/-1后，从当前KeyNode链表转移到新的ValueNode对应的KeyNode链表

如果KeyNode移动之后，原来的ValueNode对应的KeyNode链表为空，则删除原来的ValueNode

在操作完毕后如果涉及到head和tail的变更，则更新head和tail
```

**GetMaxKey() / GetMinKey()**

直接返回head / tail对应ValueNode节点中first属性指向的KeyNode节点的key值。
