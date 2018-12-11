# 原题
一个链表中的每一个节点都有一个额外的随机指针，指向链表中的任意节点或空节点。对这个链表进行深拷贝。

注意点：

  - 无

例子:

输入: 略

输出: 略

# 解题思路
如果要copy一个带有random pointer的list，主要的问题就是有可能这个random指向的位置还没有被copy到，所以解决方法都是多次扫描list。

第一种方法，就是使用HashMap来坐，HashMap的key存原始pointer，value存新的pointer。

第一遍，先不copy random的值，只copy数值建立好新的链表。并把新旧pointer存在HashMap中。

第二遍，遍历旧表，复制random的值，因为第一遍已经把链表复制好了并且也存在HashMap里了，所以只需从HashMap中，把当前旧的node.random作为key值，得到新的value的值，并把其赋给新node.random就好。

代码如下：

```java
public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head,newhead);
        RandomListNode oldp = head.next;
        RandomListNode newp = newhead;
        while(oldp!=null){
            RandomListNode newnode = new RandomListNode(oldp.label);
            map.put(oldp,newnode);
            newp.next = newnode;
            
            oldp = oldp.next;
            newp = newp.next;
        }
        
        oldp = head;
        newp = newhead;
        while(oldp!=null){
            newp.random = map.get(oldp.random);
            oldp = oldp.next;
            newp = newp.next;
        }
        
        return newhead;
    }
```
    
上面那种方法遍历2次list，所以时间复杂度是O(2n)=O(n)，然后使用了HashMap，所以空间复杂度是O(n)。

 
第二种方法不使用HashMap来做，使空间复杂度降为O(1)，不过需要3次遍历list，时间复杂度为O(3n)=O(n)。

第一遍，对每个node进行复制，并插入其原始node的后面，新旧交替，变成重复链表。如：原始：1->2->3->null，复制后：1->1->2->2->3->3->null

第二遍，遍历每个旧node，把旧node的random的复制给新node的random，因为链表已经是新旧交替的。所以复制方法为：

                                      node.next.random = node.random.next

             前面是说旧node的next的random，就是新node的random，后面是旧node的random的next，正好是新node，是从旧random复制来的。

 第三遍，则是把新旧两个表拆开，返回新的表即可。

 

代码如下：
```java
public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)  
            return head;  
        RandomListNode node = head;  
        while(node!=null){
            RandomListNode newNode = new RandomListNode(node.label);  
            newNode.next = node.next;  
            node.next = newNode;  
            node = newNode.next;  
        } 
        
        node = head;  
        while(node!=null){
            if(node.random != null)  
                node.next.random = node.random.next;  
            node = node.next.next;  
        }
        
        RandomListNode newHead = head.next;  
        node = head;  
        while(node != null){  
            RandomListNode newNode = node.next;  
            node.next = newNode.next;  
            if(newNode.next!=null)  
                newNode.next = newNode.next.next;  
            node = node.next;  
        }  
        return newHead;  
     }
 ```
